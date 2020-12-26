public class Solution {
    public int findCircleNum(int[][] M) {
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
        for (int i = 0; i < M[cur].length; i++) {
            if (M[cur][i] == 1 && !visited[i]) {
                dfs(i, M, visited);
            }
        }
    }
    
    public static void main(String[] args) {
        int[][] M = {
                {1, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 1},
                {1, 0, 1, 1}};
        System.out.println(new Solution().findCircleNum(M));
    }
}
