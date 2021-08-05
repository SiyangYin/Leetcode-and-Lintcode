public class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int res = 0;
        for (int x : left) {
            res = Math.max(res, x);
        }
        for (int x : right) {
            res = Math.max(res, n - x);
        }
        
        return res;
    }
}
