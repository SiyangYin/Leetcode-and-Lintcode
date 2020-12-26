import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        boolean end = false;
        while (!queue.isEmpty()) {
            TreeNode x = queue.poll();
            if (end && x != null) {
                return false;
            }
            
            if (x == null) {
                end = true;
            } else {
                queue.offer(x.left);
                queue.offer(x.right);
            }
        }
        
        return true;
    }
}
