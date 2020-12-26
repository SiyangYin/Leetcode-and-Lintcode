import java.util.ArrayList;
import java.util.List;

public class Solution {
    public Node cloneTree(Node root) {
        return dfs(root);
    }
    
    private Node dfs(Node root) {
        if (root == null) {
            return null;
        }
        
        Node res = new Node(root.val);
        for (Node child : root.children) {
            res.children.add(dfs(child));
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        Node root = new Node(1);
        root.children.add(new Node(3));
        root.children.add(new Node(2));
        root.children.add(new Node(4));
        root.children.get(0).children.add(new Node(5));
        root.children.get(0).children.add(new Node(6));
    
        Node node = new Solution().cloneTree(root);
        System.out.println(node);
    }
}

class Node {
    public int val;
    public List<Node> children;
    
    
    public Node() {
        children = new ArrayList<>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<>();
    }
    
    public Node(int _val, ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
}