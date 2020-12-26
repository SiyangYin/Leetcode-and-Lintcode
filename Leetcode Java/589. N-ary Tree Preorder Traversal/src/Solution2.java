import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        preorderTraversal(root, res);
        return res;
    }
    
    private void preorderTraversal(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        if (root.children != null) {
            for (Node child : root.children) {
                preorderTraversal(child, res);
            }
        }
    }
}
