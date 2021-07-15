public class Solution {
    public int minStartValue(int[] nums) {
        int res = 0, a = 0;
        for (int x : nums) {
            a += x;
            res = Math.min(res, a);
        }
        
        return res < 0 ? 1 - res : 1;
    }
}
