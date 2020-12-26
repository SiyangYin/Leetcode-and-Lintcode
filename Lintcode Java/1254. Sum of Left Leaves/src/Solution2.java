import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
    /**
     * @param root: t
     * @return: the sum of all left leaves
     */
    public int sumOfLeftLeaves(TreeNode root) {
        // Write your code here
        if (root == null) {
            return 0;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        int res = 0;
        
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll(), parent = queue.poll();
            if (parent != null && cur.left == null && cur.right == null && cur == parent.left) {
                res += cur.val;
            }
            
            if (cur.left != null) {
                queue.offer(cur.left);
                queue.offer(cur);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
                queue.offer(cur);
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        
        System.out.println(new Solution2().sumOfLeftLeaves(root));
    }
}
