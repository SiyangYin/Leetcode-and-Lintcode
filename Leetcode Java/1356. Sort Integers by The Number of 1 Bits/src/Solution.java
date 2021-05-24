import java.util.Arrays;

public class Solution {
    public int[] sortByBits(int[] A) {
        int[][] tmp = new int[A.length][];
        for (int i = 0; i < A.length; i++) {
            tmp[i] = new int[]{A[i], cnt(A[i])};
        }
    
        Arrays.sort(tmp, (x, y) -> x[1] != y[1] ? Integer.compare(x[1], y[1]) : Integer.compare(x[0], y[0]));
        int[] res = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            res[i] = tmp[i][0];
        }
        
        return res;
    }
    
    private int cnt(int x) {
        int res = 0;
        while (x > 0) {
            x -= x & -x;
            res++;
        }
        
        return res;
    }
}
