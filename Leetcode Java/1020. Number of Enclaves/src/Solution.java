public class Solution {
    public int numEnclaves(int[][] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        
        for (int i = 0; i < A.length; i++) {
            if (A[i][0] == 1) {
                dfs(A, i, 0, dirs, 2);
            }
            if (A[i][A[0].length - 1] == 1) {
                dfs(A, i, A[0].length - 1, dirs, 2);
            }
        }
        
        for (int i = 0; i < A[0].length; i++) {
            if (A[0][i] == 1) {
                dfs(A, 0, i, dirs, 2);
            }
            if (A[A.length - 1][i] == 1) {
                dfs(A, A.length - 1, i, dirs, 2);
            }
        }
    
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1) {
                    ans += 1;
                }
            }
        }
        
        return ans;
    }
    
    private void dfs(int[][] A, int x, int y, int[][] dirs, int fill) {
        A[x][y] = fill;
        for (int i = 0; i < 4; i++) {
            int newX = x + dirs[i][0];
            int newY = y + dirs[i][1];
            if (0 <= newX && newX < A.length && 0 <= newY && newY < A[0].length && A[newX][newY] == 1) {
                dfs(A, newX, newY, dirs, fill);
            }
        }
    }
    
    public static void main(String[] args) {
        int[][] A =
                {       {0, 0, 0, 1, 1, 1, 0, 1, 0, 0},
                        {1, 1, 0, 0, 0, 1, 0, 1, 1, 1},
                        {0, 0, 0, 1, 1, 1, 0, 1, 0, 0},
                        {0, 1, 1, 0, 0, 0, 1, 0, 1, 0},
                        {0, 1, 1, 1, 1, 1, 0, 0, 1, 0},
                        {0, 0, 1, 0, 1, 1, 1, 1, 0, 1},
                        {0, 1, 1, 0, 0, 0, 1, 1, 1, 1},
                        {0, 0, 1, 0, 0, 1, 0, 1, 0, 1},
                        {1, 0, 1, 0, 1, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 1, 0, 0, 0, 1}};
        
        System.out.println(new Solution().numEnclaves(A));
    }
}
