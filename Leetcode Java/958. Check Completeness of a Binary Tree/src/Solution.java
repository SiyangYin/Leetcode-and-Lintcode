import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        // 如果遇到某个节点只有右孩子而没有左孩子，就做下标记
        // 接下来入队的节点都不能有孩子
        boolean alert = false;
        while (!queue.isEmpty()) {
            TreeNode x = queue.poll();
            if (alert && (x.left != null || x.right != null)) {
                return false;
            }
            if (x.left == null && x.right != null) {
                return false;
            }
            
            if (x.left == null || x.right == null) {
                alert = true;
            }
            
            if (x.left != null) {
                queue.offer(x.left);
            }
            if (x.right != null) {
                queue.offer(x.right);
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(6);
    
        System.out.println(new Solution().isCompleteTree(root));
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}