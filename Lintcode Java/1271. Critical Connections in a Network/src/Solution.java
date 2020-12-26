import java.util.*;

public class Solution {
    /**
     * @param n:           the number of servers
     * @param connections: connections
     * @return: Critical Connections in a Network
     */
    public List<List<Integer>> criticalConnectionsinaNetwork(int n, List<List<Integer>> connections) {
        // write your code here
        Map<Integer, List<Integer>> graph = new HashMap<>();
    
        for (int i = 0; i < n; i++) {
            graph.putIfAbsent(i, new ArrayList<>());
        }
        for (List<Integer> connection : connections) {
            int x = connection.get(0), y = connection.get(1);
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[n];
        int[] low = new int[n], ord = new int[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, i, 0, ord, low, graph, visited, res);
            }
        }
        return res;
    }
    
    private void dfs(int cur, int parent, int cnt, int[] ord, int[] low, Map<Integer, List<Integer>> graph, boolean[] visited, List<List<Integer>> res) {
        visited[cur] = true;
        ord[cur] = low[cur] = cnt;
    
        for (int next : graph.get(cur)) {
            if (!visited[next]) {
                dfs(next, cur, cnt + 1, ord, low, graph, visited, res);
                low[cur] = Math.min(low[cur], low[next]);
                
                if (low[next] > ord[cur]) {
                    List<Integer> edge = new ArrayList<>();
                    edge.add(cur);
                    edge.add(next);
                    if (cur > next) {
                        Collections.swap(edge, 0, 1);
                    }
                    res.add(edge);
                }
                
            } else if (next != parent) {
                low[cur] = Math.min(low[cur], low[next]);
            }
        }
    }
    
    public static void main(String[] args) {
        int n = 15;
        List<List<Integer>> con = new ArrayList<>();
        con.add(Arrays.asList(0, 1));
        con.add(Arrays.asList(1, 2));
        con.add(Arrays.asList(2, 3));
        con.add(Arrays.asList(3, 4));
        con.add(Arrays.asList(4, 5));
        con.add(Arrays.asList(5, 6));
        con.add(Arrays.asList(6, 7));
        con.add(Arrays.asList(7, 9));
        con.add(Arrays.asList(9, 8));
        con.add(Arrays.asList(8, 10));
        con.add(Arrays.asList(10, 11));
        con.add(Arrays.asList(11, 12));
        con.add(Arrays.asList(12, 13));
        con.add(Arrays.asList(13, 14));
        System.out.println(con.size());
        System.out.println(new Solution().criticalConnectionsinaNetwork(n, con));
        System.out.println(new Solution().criticalConnectionsinaNetwork(n, con).size());
    }
}
