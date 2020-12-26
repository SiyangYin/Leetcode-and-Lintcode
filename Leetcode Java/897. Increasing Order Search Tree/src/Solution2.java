import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public TreeNode increasingBST(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        inorder(root, list);
        if (list.isEmpty()) {
            return null;
        }
        
        TreeNode res = list.get(0), cur = res;
        res.left = null;
        for (int i = 1; i < list.size(); i++) {
            cur.right = list.get(i);
            cur.left = null;
            cur = cur.right;
        }
        
        return res;
    }
    
    private void inorder(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        
        inorder(root.left, list);
        list.add(root);
        inorder(root.right, list);
    }
}
