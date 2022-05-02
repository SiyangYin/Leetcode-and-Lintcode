import java.util.Arrays;

public class Solution2 {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] f = new int[n];
        Arrays.fill(f, 1);
        for (int i = 0; i < n - 1; i++) {
            if (ratings[i + 1] > ratings[i]) {
                f[i + 1] = Math.max(f[i + 1], f[i] + 1);
            }
        }
        for (int i = n - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i]) {
                f[i - 1] = Math.max(f[i - 1], f[i] + 1);
            }
        }
        
        int res = 0;
        for (int x : f) {
            res += x;
        }
        
        return res;
    }
}
