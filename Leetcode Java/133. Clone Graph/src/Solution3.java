import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution3 {
    public Node cloneGraph(Node node) {
        if (node == null) return node;
        Map<Node, Node> map = new HashMap<>();
        Node copy = new Node(node.val);
        map.put(node, copy);
        dfs(node, copy, map);
        return copy;
    }

    public void dfs(Node node, Node copy, Map<Node, Node> map) {
        for (Node neighbor : node.neighbors) {
            if (map.containsKey(neighbor)) {
                copy.neighbors.add(map.get(neighbor));
            }
            else {
                Node neighborCopy = new Node(neighbor.val);
                copy.neighbors.add(neighborCopy);
                map.put(neighbor, neighborCopy);
                dfs(neighbor, neighborCopy, map);
            }
        }
    }
}
