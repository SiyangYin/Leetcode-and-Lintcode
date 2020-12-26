import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    /**
     * @param root: the root of binary tree.
     * @return: true if it is a complete binary tree, or false.
     */
    public boolean isComplete(TreeNode root) {
        // write your code here
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
    
        boolean lastRow = false;
        while (!queue.isEmpty()) {
            TreeNode x = queue.poll();
            if (lastRow && x != null) {
                return false;
            }
        
            if (x == null) {
                lastRow = true;
            } else {
                queue.offer(x.left);
                queue.offer(x.right);
            }
        }
    
        return true;
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}