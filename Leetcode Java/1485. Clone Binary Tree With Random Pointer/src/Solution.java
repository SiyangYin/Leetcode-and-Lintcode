import java.util.HashMap;
import java.util.Map;

public class Solution {
    public NodeCopy copyRandomBinaryTree(Node root) {
        Map<Node, NodeCopy> map = new HashMap<>();
        map.put(null, null);
        
        dfs(root, map);
        
        return map.get(root);
    }
    
    private NodeCopy dfs(Node cur, Map<Node, NodeCopy> map) {
        if (map.containsKey(cur)) {
            return map.get(cur);
        }
        
        map.put(cur, new NodeCopy(cur.val));
        NodeCopy curCopy = map.get(cur);
        curCopy.left = dfs(cur.left, map);
        curCopy.right = dfs(cur.right, map);
        curCopy.random = dfs(cur.random, map);
        
        return curCopy;
    }
}

class Node {
    int val;
    Node left, right, random;
    
    public Node() {
    }
    
    public Node(int val) {
        this.val = val;
    }
    
    public Node(int val, Node left, Node right, Node random) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.random = random;
    }
}

class NodeCopy {
    int val;
    NodeCopy left, right, random;
    
    public NodeCopy() {
    }
    
    public NodeCopy(int val) {
        this.val = val;
    }
    
    public NodeCopy(int val, NodeCopy left, NodeCopy right, NodeCopy random) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.random = random;
    }
}