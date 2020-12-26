import java.util.*;

public class Solution2 {
    public List<List<Integer>> connectedSet(List<UndirectedGraphNode> nodes) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if (nodes == null || nodes.isEmpty()) {
            return res;
        }
       
        Set<UndirectedGraphNode> visited = new HashSet<>();
        for (UndirectedGraphNode node : nodes) {
            if (!visited.contains(node)) {
                List<Integer> comp = new ArrayList<>();
                dfs(node, comp, visited);
                Collections.sort(comp);
                res.add(comp);
            }
        }
        
        return res;
    }
    
    private void dfs(UndirectedGraphNode node, List<Integer> cur, Set<UndirectedGraphNode> visited) {
        cur.add(node.label);
        visited.add(node);
    
        for (UndirectedGraphNode neighbor : node.neighbors) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, cur, visited);
            }
        }
    }
}
