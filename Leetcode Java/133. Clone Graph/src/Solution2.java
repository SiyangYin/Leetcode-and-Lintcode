import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        
        Map<Node, Node> map = new HashMap<>();
        
        return dfs(node, map);
    }
    
    private Node dfs(Node node, Map<Node, Node> map) {
        if (map.containsKey(node)) {
            return map.get(node);
        }
        
        map.put(node, new Node(node.val, new ArrayList<>()));
    
        for (Node neighbor : node.neighbors) {
            map.get(node).neighbors.add(dfs(neighbor, map));
        }
        
        return map.get(node);
    }
}
