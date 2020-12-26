import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        
        if (root == null) {
            return res;
        }
        
        if (root.left == null && root.right == null) {
            res.add(Integer.toString(root.val));
            return res;
        }
        
        List<String> leftPaths = binaryTreePaths(root.left);
        for (String leftPath : leftPaths) {
            res.add(root.val + "->" + leftPath);
        }
        List<String> rightPaths = binaryTreePaths(root.right);
        for (String rightPath : rightPaths) {
            res.add(root.val + "->" + rightPath);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(new Solution2().binaryTreePaths(root));
    }
}
