import java.util.PriorityQueue;

public class Solution2 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                minHeap.offer(nums[i]);
            } else if (nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
        
        return minHeap.peek();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution2().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }
}
