import java.util.Arrays;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        
        int start;
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        
        if (nums[l] != target) {
            return new int[]{-1, -1};
        }
        
        start = l;
        l = start;
        r = nums.length - 1;
        while (l < r) {
            int mid = l + ((r - l + 1) >> 1);
            if (nums[mid] <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return new int[]{start, l};
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
    }
}
