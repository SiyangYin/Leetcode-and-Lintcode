import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    /**
     * @param root: the root of the binary tree
     * @return: all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        // write your code here
        List<String> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }
        helper(root, String.valueOf(root.val), paths);
        return paths;
    }
    
//    从上向下遍历
//    path存放的是从root到当前结点的路径
    public void helper(TreeNode root, String path, List<String> paths) {
        if (root == null) {
            return;
        }
        
        if (root.left == null && root.right == null) {
//          是叶子，把root到当前结点路径加到paths里
            paths.add(String.valueOf(root.val));
            return;
        }
        
        if (root.left != null) {
            helper(root.left, path + "->" + String.valueOf(root.left.val), paths);
        }
        
        if (root.right != null) {
            helper(root.right, path + "->" + String.valueOf(root.right.val), paths);
        }
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(4);
        System.out.println(new Solution().binaryTreePaths(root));

    }
}
