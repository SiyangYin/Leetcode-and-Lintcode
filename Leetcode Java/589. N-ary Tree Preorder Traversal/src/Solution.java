import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        
        res.add(root.val);
        if (root.children != null) {
            for (Node child : root.children) {
                res.addAll(preorder(child));
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        Node root = new Node(1);
        System.out.println(root.children);
        root.children = new ArrayList<>();
        root.children.add(new Node(3));
        root.children.get(0).children = new ArrayList<>();
        root.children.get(0).children.add(new Node(5));
        root.children.get(0).children.add(new Node(6));
        root.children.add(new Node(2));
        root.children.add(new Node(4));
    
        
        System.out.println(new Solution2().preorder(root));
    }
}

class Node {
    public int val;
    public List<Node> children;
    
    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }
    
    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
