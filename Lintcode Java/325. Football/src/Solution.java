import java.util.Arrays;

public class Solution {
    /**
     * @param probability: the winning probability of 16 teams in pairs
     * @return: return the index of the winner with the highest probability of winning
     */
    public int findWinner(double[][] probability) {
        // write your code here
        double[][] f = new double[5][16];
        Arrays.fill(f[0], 1.0);
        
        for (int k = 1; k <= 4; k++) {
            for (int i = 0; i < 16; i++) {
                for (int j = 0; j < 16; j++) {
                    if ((i >> k - 1 ^ 1) == (j >> k - 1)) {
                        f[k][i] += f[k - 1][i] * f[k - 1][j] * probability[i][j];
                    }
                }
            }
        }
        
        int res = 0;
        for (int i = 0; i < 16; i++) {
            if (f[4][i] > f[4][res]) {
                res = i;
            }
        }
        
        return res;
    }
}
