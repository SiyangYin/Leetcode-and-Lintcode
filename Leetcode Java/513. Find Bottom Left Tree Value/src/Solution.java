import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = 0;
        while (!queue.isEmpty()) {
            TreeNode x = queue.poll();
            res = x.val;
            if (x.right != null) {
                queue.offer(x.right);
            }
            if (x.left != null) {
                queue.offer(x.left);
            }
        }
        
        return res;
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    TreeNode(int x) {
        val = x;
    }
}
