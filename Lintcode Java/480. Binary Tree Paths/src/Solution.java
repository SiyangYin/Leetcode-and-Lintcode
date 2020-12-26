import java.util.ArrayList;
import java.util.List;

public class Solution {
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
        if (root.left == null && root.right == null) {
            paths.add(String.valueOf(root.val));
        }
        List<String> leftPaths = binaryTreePaths(root.left);
        List<String> rightPaths = binaryTreePaths(root.right);
        
        for (String path : leftPaths) {
            paths.add(root.val + "->" + path);
        }
        for (String path : rightPaths) {
            paths.add(root.val + "->" + path);
        }
        return paths;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(4);
        System.out.println(new Solution().binaryTreePaths(root));
        
//        int[] a = null;
//        for (int i : a) {
//            System.out.println(i);
//        }
    }
}