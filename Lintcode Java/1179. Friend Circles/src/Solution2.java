public class Solution2 {
    /**
     * @param M: a matrix
     * @return: the total number of friend circles among all the students
     */
    public int findCircleNum(int[][] M) {
        // Write your code here
        if (M == null || M.length == 0 || M[0].length == 0) {
            return 0;
        }
        
        int res = 0;
        boolean[] visited = new boolean[M.length];
        for (int i = 0; i < M.length; i++) {
            if (!visited[i]) {
                dfs(i, M, visited);
                res++;
            }
        }
        
        return res;
    }
    
    private void dfs(int cur, int[][] M, boolean[] visited) {
        visited[cur] = true;
        for (int i = 0; i < M[0].length; i++) {
            if (M[cur][i] == 1 && !visited[i]) {
                dfs(i, M, visited);
            }
        }
    }
}
