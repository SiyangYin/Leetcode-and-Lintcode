import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
    
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            TreeNode x = queue.poll();
            TreeNode y = queue.poll();
            if (x == null && y == null) {
                continue;
                // return true;
            }
            if ((x == null || y == null) || (x.val != y.val)) {
                return false;
            }
            queue.offer(x.left);
            queue.offer(y.right);
            queue.offer(x.right);
            queue.offer(y.left);
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        // root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        // root.right.right = new TreeNode(3);
        System.out.println(new Solution().isSymmetric(root));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}