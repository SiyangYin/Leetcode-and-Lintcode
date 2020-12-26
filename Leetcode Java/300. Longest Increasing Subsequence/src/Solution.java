public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        // 长度为i+1的已知最长上升子序列的末尾数的最小值
        int[] f = new int[nums.length];
        f[0] = nums[0];
        int len = 1;
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > f[len - 1]) {
                f[len++] = nums[i];
            } else {
                int left = 0, right = len - 1;
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (f[mid] < nums[i]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
    
                if (f[left] >= nums[i]) {
                    f[left] = nums[i];
                }
            }
        }
        
        return len;
    }
    
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        // nums = new int[]{4, 10, 4, 3, 8, 9};
        System.out.println(new Solution().lengthOfLIS(nums));
    }
}
