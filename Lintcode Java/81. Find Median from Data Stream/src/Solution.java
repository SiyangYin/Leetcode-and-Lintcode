import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) {
        // write your code here
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((i1, i2) -> i2 < i1 ? -1 : 1), minHeap = new PriorityQueue<>();
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = add(nums[i], maxHeap, minHeap);
        }
        
        return res;
    }
    
    private int add(int num, PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
        if (maxHeap.isEmpty()) {
            maxHeap.offer(num);
            return num;
        }
        
        if (num <= maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }
        
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        } else if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        }
        return maxHeap.peek();
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().medianII(new int[]{1, 2, 3, 4, 5})));
    }
}
