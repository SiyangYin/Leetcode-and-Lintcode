import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        while (root != null) {
            List<Integer> leaves = new ArrayList<>();
            root = dfs(root, leaves);
            res.add(leaves);
        }
        
        return res;
    }
    
    private TreeNode dfs(TreeNode root, List<Integer> cur) {
        if (root == null) {
            return null;
        }
        
        if (root.left == null && root.right == null) {
            cur.add(root.val);
            return null;
        }
        
        root.left = dfs(root.left, cur);
        root.right = dfs(root.right, cur);
        return root;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(new Solution().findLeaves(root));
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}
