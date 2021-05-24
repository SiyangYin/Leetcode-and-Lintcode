public class Solution {
    public int[] xorQueries(int[] A, int[][] queries) {
        int[] res = new int[queries.length];
        for (int i = 1; i < A.length; i++) {
            A[i] ^= A[i - 1];
        }
    
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0], r = queries[i][1];
            res[i] = A[r] ^ (l == 0 ? 0 : A[l - 1]);
        }
        
        return res;
    }
}
