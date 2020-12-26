public class Solution {
    /**
     * @param v1: the speed of GGbond
     * @param v2: the speed of SuperQ
     * @param s: the speed that lollipop can add
     * @param w: the cost of lollipop
     * @return: the minimal price
     */
    public int getAns(int v1, int v2, int[] s, int[] w) {
        // Write your code here
        if (v1 > v2) {
            return 0;
        }
        
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < s.length; i++) {
            if (v1 + s[i] > v2) {
                res = Math.min(res, w[i]);
            }
        }
        
        return res;
    }
}
