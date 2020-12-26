public class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        
        int[] f = new int[3];
        
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                f[idx++] = nums[i];
            } else {
                int pos = search(f, idx - 1, nums[i]);
                if (pos == -1) {
                    f[idx++] = nums[i];
                } else {
                    f[pos] = nums[i];
                }
            }
            
            if (idx >= 3) {
                return true;
            }
        }
        
        return false;
    }
    
    // 找到第一个大于等于target的数
    private int search(int[] nums, int r, int target) {
        for (int i = 0; i <= r; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().increasingTriplet(new int[]{1, 2, 3, 4}));
    }
}
