import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }
    
    private void preorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(new Solution2().preorderTraversal(root));
    }
}
