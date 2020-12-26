public class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int[] ldp = new int[nums.length], rdp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ldp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    ldp[i] = Math.max(ldp[i], ldp[j] + 1);
                }
            }
        }
    
        for (int i = nums.length - 1; i >= 0; i--) {
            rdp[i] = 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    rdp[i] = Math.max(rdp[i], rdp[j] + 1);
                }
            }
        }
    
        int res = nums.length;
        for (int i = 1; i < nums.length - 1; i++) {
            res = Math.min(res, nums.length - ldp[i] - rdp[i] + 1);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().minimumMountainRemovals(new int[]{2, 1, 1, 5, 6, 2, 3, 1}));
    }
}
