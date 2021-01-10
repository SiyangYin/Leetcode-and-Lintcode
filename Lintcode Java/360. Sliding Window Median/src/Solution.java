import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    /**
     * @param nums: A list of integers
     * @param k:    An integer
     * @return: The median of the element inside the window at each moving
     */
    public List<Integer> medianSlidingWindow(int[] nums, int k) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(), maxHeap = new PriorityQueue<>((x, y) -> -Integer.compare(x, y));
        
        for (int i = 0; i < nums.length; i++) {
            if (maxHeap.isEmpty() || nums[i] <= maxHeap.peek()) {
                maxHeap.offer(nums[i]);
            } else {
                minHeap.offer(nums[i]);
            }
            
            if (i >= k) {
                if (nums[i - k] <= maxHeap.peek()) {
                    maxHeap.remove(nums[i - k]);
                } else {
                    minHeap.remove(nums[i - k]);
                }
            }
            adjust(maxHeap, minHeap);
            
            if (i >= k - 1) {
                res.add(maxHeap.peek());
            }
        }
        
        return res;
    }
    
    private void adjust(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
        while (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
        
        while (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().medianSlidingWindow(new int[]{1, 2, 7, 7, 2, 10, 3, 4, 5}, 2));
    }
}
