public class Solution {
    public int[][] imageSmoother(int[][] M) {
        int[][] res = new int[M.length][M[0].length];
        
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                int sum = 0, count = 0;
                for (int dx = -1; dx <= 1; dx++) {
                    for (int dy = -1; dy <= 1; dy++) {
                        if (0 <= i + dx && i + dx < M.length && 0 <= j + dy && j + dy < M[0].length) {
                            sum += M[i + dx][j + dy];
                            count++;
                        }
                    }
                }
                
                res[i][j] = sum / count;
            }
        }
        
        return res;
    }
}
