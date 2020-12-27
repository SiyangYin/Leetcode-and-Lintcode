public class Solution {
    public int minMoves(int[] nums) {
        int res = 0, min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
        }
        
        for (int num : nums) {
            res += num - min;
        }
        
        return res;
    }
}
