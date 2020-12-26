import java.util.PriorityQueue;

public class Solution {
    /**
     * @param nums: an integer unsorted array
     * @param k: an integer from 1 to n
     * @return: the kth largest element
     */
    public int kthLargestElement2(int[] nums, int k) {
        // write your code here
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                minHeap.offer(nums[i]);
            } else {
                if (nums[i] > minHeap.peek()) {
                    minHeap.poll();
                    minHeap.offer(nums[i]);
                }
            }
        }
        
        return minHeap.peek();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().kthLargestElement2(new int[]{9, 3, 2, 4, 8}, 3));
    }
}
