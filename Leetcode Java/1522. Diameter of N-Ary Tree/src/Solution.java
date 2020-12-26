import java.util.ArrayList;
import java.util.List;

public class Solution {
    
    private int res;
    
    public int diameter(Node root) {
        dfs(root);
        return res;
    }
    
    private int dfs(Node root) {
        if (root == null) {
            return 0;
        }
        
        int max = 0, secondMax = 0;
        for (Node child : root.children) {
            int len = dfs(child);
            if (len > max) {
                secondMax = max;
                max = len;
            } else if (len > secondMax) {
                secondMax = len;
            }
        }
        
        res = Math.max(res, max + secondMax);
        
        return 1 + max;
    }
}

class Node {
    int val;
    List<Node> children;
    
    public Node() {
        children = new ArrayList<>();
    }
    
    public Node(int val) {
        this.val = val;
        children = new ArrayList<>();
    }
    
    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}