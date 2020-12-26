public class Solution {
    public int arrayNesting(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == -1) {
                continue;
            }
            
            int len = 0, idx = i;
            do {
                int tmp = nums[idx];
                nums[idx] = -1;
                idx = tmp;
                len++;
            } while (idx != i);
            
            res = Math.max(res, len);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().arrayNesting(new int[]{5, 4, 0, 3, 1, 6, 2}));
    }
}
