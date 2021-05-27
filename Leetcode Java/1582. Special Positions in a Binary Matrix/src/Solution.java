public class Solution {
    public int numSpecial(int[][] mat) {
        int[] row1 = new int[mat.length], col1 = new int[mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    row1[i]++;
                    col1[j]++;
                }
            }
        }
        
        int res = 0;
        for (int i = 0; i < mat.length; i++) {
            if (row1[i] != 1) {
                continue;
            }
            
            for (int j = 0; j < mat[0].length; j++) {
                if (col1[j] != 1) {
                    continue;
                }
                
                if (mat[i][j] == 1) {
                    res++;
                }
            }
        }
        
        return res;
    }
}
