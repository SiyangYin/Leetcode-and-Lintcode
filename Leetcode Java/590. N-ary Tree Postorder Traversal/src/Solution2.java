import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        postorderTraversal(root, res);
        return res;
    }
    
    private void postorderTraversal(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }
        
        if (root.children != null) {
            for (Node child : root.children) {
                postorderTraversal(child, res);
            }
        }
        res.add(root.val);
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
        
        
        System.out.println(new Solution2().postorder(root));
    }
}
