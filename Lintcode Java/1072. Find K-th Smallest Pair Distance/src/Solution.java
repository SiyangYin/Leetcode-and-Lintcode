import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    /**
     * @param nums: a list of integers
     * @param k:    a integer
     * @return: return a integer
     */
    public int smallestDistancePair(int[] nums, int k) {
        // write your code here
        Arrays.sort(nums);
        k = nums.length * (nums.length - 1) / 2 - k + 1;
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((p1, p2) -> -Integer.compare(nums[p1[1]] - nums[p1[0]], nums[p2[1]] - nums[p2[0]]));
        maxHeap.offer(new int[]{0, nums.length - 1});
        while (!maxHeap.isEmpty()) {
            int[] cur = maxHeap.poll();
            
            k--;
            int j = cur[0], i = cur[1];
            if (k == 0) {
                return nums[i] - nums[j];
            }
            
            if (j + 1 < i) {
                maxHeap.offer(new int[]{j + 1, i});
                maxHeap.offer(new int[]{j, i - 1});
            }
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().smallestDistancePair(new int[]{1, 3, 1}, 1));
        System.out.println(new Solution().smallestDistancePair(new int[]{2, 2, 0, 1, 1, 0, 0, 1, 2, 0}, 2));
    }
}
