import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
  
    public boolean isSubtree(TreeNode s, TreeNode t) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(s);
        while (!queue.isEmpty()) {
            TreeNode x = queue.poll();
            if (checkEquitree(x, t)) {
                return true;
            }
            if (x != null) {
                queue.offer(x.left);
                queue.offer(x.right);
            }
        }
        return false;
    }
    
    private boolean checkEquitree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return checkEquitree(root1.left, root2.left) && checkEquitree(root1.right, root2.right);
    }
    
    public static void main(String[] args) {
        TreeNode s = new TreeNode(3);
        s.left = new TreeNode(4);
        s.right = new TreeNode(5);
        s.left.left = new TreeNode(1);
        s.left.right = new TreeNode(2);
        
        TreeNode t = new TreeNode(4);
        t.left = new TreeNode(1);
        t.right = new TreeNode(2);
        System.out.println(new Solution2().isSubtree(s, t));
    }
}
