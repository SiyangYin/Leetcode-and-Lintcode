import java.util.*;

public class Solution {
    
    int[] p;
    int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        
        return p[x];
    }
    
    public int[][] matrixRankTransform(int[][] A) {
        if (A.length == 0 || A[0].length == 0) {
            return A;
        }
        
        int m = A.length, n = A[0].length;
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map.putIfAbsent(A[i][j], new ArrayList<>());
                map.get(A[i][j]).add(i * n + j);
            }
        }
        
        int[] rk = new int[m + n];
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            p = new int[m + n];
            for (int i = 0; i < p.length; i++) {
                p[i] = i;
            }
    
            int[] rk2 = rk.clone();
            List<Integer> list = entry.getValue();
            for (int xy : list) {
                int x = xy / n, y = xy % n;
                x = find(x);
                y = find(y + m);
                p[x] = y;
                rk2[y] = Math.max(rk2[x], rk2[y]);
            }
            for (int xy : list) {
                int x = xy / n, y = xy % n;
                rk[x] = rk[y + m] = A[x][y] = rk2[find(x)] + 1;
            }
        }
        
        return A;
    }
    
    public static void main(String[] args) {
        int[][] A = {
                {-37, -50, -3, 44},
                {-37, 46, 13, -32},
                {47, -42, -3, -40},
                {-17, -22, -39, 24}
        };
        System.out.println(Arrays.deepToString(new Solution().matrixRankTransform(A)));
    }
}
