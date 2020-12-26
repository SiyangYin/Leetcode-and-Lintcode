public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int l = 0, r = 0;
        int res = 0;
        while (true) {
            while (l < nums.length && nums[l] != 1) {
                l++;
            }
            
            if (l == nums.length) {
                break;
            }
            
            r = l;
            while (r < nums.length && nums[r] == 1) {
                r++;
            }
            
            res = Math.max(res, r - l);
            l = r;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1};
        System.out.println(new Solution().findMaxConsecutiveOnes(nums));
        System.out.println(nums.length);
    }
}
