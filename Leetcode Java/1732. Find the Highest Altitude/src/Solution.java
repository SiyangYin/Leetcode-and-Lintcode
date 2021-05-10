public class Solution {
    public int largestAltitude(int[] gain) {
        int res = 0, sum = 0;
        for (int x : gain) {
            sum += x;
            res = Math.max(res, sum);
        }
        
        return res;
    }
}
