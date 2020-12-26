import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        
        if (root.children != null) {
            for (Node child : root.children) {
                res.addAll(postorder(child));
            }
        }
        res.add(root.val);
        
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
        
        
        System.out.println(new Solution().postorder(root));
    }
}

class Node {
    public int val;
    public List<Node> children;
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<>();
    }
}