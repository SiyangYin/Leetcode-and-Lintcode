import java.util.Arrays;

public class Solution {
    public boolean makesquare(int[] A) {
        int len = 0;
        for (int x : A) {
            len += x;
        }
        if (len % 4 != 0) {
            return false;
        }
        
        len /= 4;
        Arrays.sort(A);
        reverse(A);
        boolean[] vis = new boolean[A.length];
        return dfs(0, 0, len, 0, A, vis);
    }
    
    void reverse(int[] A) {
        for (int i = 0, j = A.length - 1; i < j; i++, j--) {
            int tmp = A[i];
            A[i] = A[j];
            A[j] = tmp;
        }
    }
    
    boolean dfs(int u, int curLen, int len, int cnt, int[] A, boolean[] vis) {
        if (cnt == 3) {
            return true;
        }
        if (curLen == len) {
            return dfs(0, 0, len, cnt + 1, A, vis);
        }
        
        for (int i = u; i < A.length; i++) {
            if (vis[i] || curLen + A[i] > len) {
                continue;
            }
            
            vis[i] = true;
            curLen += A[i];
            if (dfs(u + 1, curLen, len, cnt, A, vis)) {
                return true;
            }
            vis[i] = false;
            curLen -= A[i];
            if (curLen == 0 || curLen + A[i] == len) {
                return false;
            }
            while (i + 1 < A.length && A[i + 1] == A[i]) {
                i++;
            }
        }
        
        return false;
    }
}
