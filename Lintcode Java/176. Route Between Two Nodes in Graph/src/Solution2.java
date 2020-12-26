import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution2 {
    public boolean hasRoute(List<DirectedGraphNode> graph, DirectedGraphNode s, DirectedGraphNode t) {
        // write your code here
        return dfs(s, t, new HashSet<>());
    }
    
    private boolean dfs(DirectedGraphNode s, DirectedGraphNode t, Set<DirectedGraphNode> visited) {
        if (s == t) {
            return true;
        }
        
        visited.add(s);
        for (DirectedGraphNode neighbor : s.neighbors) {
            if (!visited.contains(neighbor) && dfs(neighbor, t, visited)) {
                return true;
            }
        }
        
        return false;
    }
}
