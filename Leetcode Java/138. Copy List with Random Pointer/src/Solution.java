import java.util.HashMap;
import java.util.Map;

public class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        
        Map<Node, Node> map = new HashMap<>();
        map.put(null, null);
        return dfs(head, map);
    }
    
    private Node dfs(Node node, Map<Node, Node> map) {
        if (map.containsKey(node)) {
            return map.get(node);
        }
        
        map.put(node, new Node(node.val));
        
        map.get(node).next = dfs(node.next, map);
        map.get(node).random = dfs(node.random, map);
        
        return map.get(node);
    }
}

class Node {
    int val;
    Node next;
    Node random;
    
    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}