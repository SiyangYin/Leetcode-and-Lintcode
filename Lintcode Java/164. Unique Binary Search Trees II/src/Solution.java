import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @paramn n: An integer
     * @return: A list of root
     */
    public List<TreeNode> generateTrees(int n) {
        // write your code here
        return build(1, n);
    }
    
    private List<TreeNode> build(int l, int r) {
        List<TreeNode> res = new ArrayList<>();
        if (l > r) {
            res.add(null);
            return res;
        }
        
        for (int i = l; i <= r; i++) {
            List<TreeNode> left = build(l, i - 1), right = build(i + 1, r);
            for (TreeNode lRoot : left) {
                for (TreeNode rRoot : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = lRoot;
                    root.right = rRoot;
                    res.add(root);
                }
            }
        }
        
        return res;
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}