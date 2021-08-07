public class Solution {
    public int maxWidthRamp(int[] nums) {
        int[] stk = new int[nums.length];
        int top = 0, res = 0;
        for (int i = 0; i < nums.length; i++) {
            int pos = binarySearch(stk, top, nums[i], nums);
            if (pos != -1) {
                res = Math.max(res, i - pos);
            }
            
            if (top == 0 || nums[i] < nums[stk[top - 1]]) {
                stk[top++] = i;
            }
        }
        
        return res;
    }
    
    private int binarySearch(int[] stk, int top, int target, int[] nums) {
        if (top == 0) {
            return -1;
        }
        
        int l = 0, r = top - 1;
        while (l < r) {
            int mid = l + (r - l >> 1);
            if (nums[stk[mid]] <= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        
        return nums[stk[l]] <= target ? stk[l] : -1;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().maxWidthRamp(new int[]{9, 8, 1, 0, 1, 9, 4, 0, 4, 1}));
        System.out.println(new Solution().maxWidthRamp(new int[]{3, 4, 1, 2}));
    }
}
