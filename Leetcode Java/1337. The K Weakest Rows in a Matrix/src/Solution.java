import java.util.Arrays;

public class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[][] info = new int[mat.length][];
        for (int i = 0; i < mat.length; i++) {
            info[i] = new int[]{i, cnt(mat[i])};
        }
        
        Arrays.sort(info, (r1, r2) -> r1[1] != r2[1] ? Integer.compare(r1[1], r2[1]) : Integer.compare(r1[0], r2[0]));
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = info[i][0];
        }
        
        return res;
    }
    
    private int cnt(int[] A) {
        int l = 0, r = A.length - 1;
        while (l < r) {
            int m = l + (r - l + 1 >> 1);
            if (A[m] == 1) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        
        return A[l] == 1 ? l + 1 : 0;
    }
}
