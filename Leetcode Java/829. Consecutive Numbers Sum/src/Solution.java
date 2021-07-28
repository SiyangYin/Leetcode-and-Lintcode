public class Solution {
    public int consecutiveNumbersSum(int n) {
        int res = 0;
        for (int i = 1; i * i + i <= 2 * n; i++) {
            if ((n - i * (i - 1) / 2) % i == 0) {
                res++;
            }
        }
        
        return res;
    }
}
