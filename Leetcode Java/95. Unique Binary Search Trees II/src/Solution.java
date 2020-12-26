import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        
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
            for (TreeNode leftRoot : left) {
                for (TreeNode rightRoot : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftRoot;
                    root.right = rightRoot;
                    res.add(root);
                }
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().generateTrees(3));
        System.out.println(new Solution().generateTrees(0));
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}
