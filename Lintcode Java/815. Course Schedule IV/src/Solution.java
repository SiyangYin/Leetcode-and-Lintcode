public class Solution {
    
    private int res;
    
    /**
     * @param n: an integer, denote the number of courses
     * @param p: a list of prerequisite pairs
     * @return: return an integer,denote the number of topologicalsort
     */
    public int topologicalSortNumber(int n, int[][] p) {
        // Write your code here
        boolean[][] graph = new boolean[n][n];
        int[] indegrees = new int[n];
        for (int[] edge : p) {
            graph[edge[1]][edge[0]] = true;
            indegrees[edge[0]]++;
        }
        
        dfs(0, graph, indegrees, new boolean[n], n);
        return res;
    }
    
    private void dfs(int curLevel, boolean[][] graph, int[] indegrees, boolean[] visited, int n) {
        if (curLevel == n) {
            res++;
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (!visited[i] && indegrees[i] == 0) {
                visited[i] = true;
                for (int j = 0; j < n; j++) {
                    if (graph[i][j]) {
                        indegrees[j]--;
                    }
                }
                
                dfs(curLevel + 1, graph, indegrees, visited, n);
                for (int j = 0; j < n; j++) {
                    if (graph[i][j]) {
                        indegrees[j]++;
                    }
                }
                visited[i] = false;
            }
        }
    }
    
    public static void main(String[] args) {
        int[][] p = {{1, 0}};
        System.out.println(new Solution().topologicalSortNumber(2, p));
    }
}
