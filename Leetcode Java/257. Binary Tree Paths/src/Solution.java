import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        
        if (root == null) {
            return res;
        }
        
        dfs(root, Integer.toString(root.val), res);
        return res;
    }
    
    private void dfs(TreeNode cur, String path, List<String> res) {
        if (cur == null) {
            return;
        }
        if (cur.left == null && cur.right == null) {
            res.add(path);
            return;
        }
        
        if (cur.left != null) {
            dfs(cur.left, path + "->" + cur.left.val, res);
        }
        if (cur.right != null) {
            dfs(cur.right, path + "->" + cur.right.val, res);
        }
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(new Solution().binaryTreePaths(root));
    }
    
}

