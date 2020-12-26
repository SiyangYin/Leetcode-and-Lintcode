import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    /**
     * @param root: the root
     * @param k: an integer
     * @return: the value of the nearest leaf node to target k in the tree
     */
    public int findClosestLeaf(TreeNode root, int k) {
        // Write your code here
        int res = Integer.MAX_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.val == k) {
                if (cur.left != null) {
                    queue.clear();
                    queue.offer(cur.left);
                    break;
                }
                if (cur.right != null) {
                    queue.clear();
                    queue.offer(cur.right);
                    break;
                }
            }
            
            if (cur.left == null && cur.right == null && Math.abs(cur.val - k) < Math.abs(res - k)) {
                res = cur.val;
            }
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
        
        if (!queue.isEmpty()) {
            res = Integer.MAX_VALUE;
        }
        
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left == null && cur.right == null && Math.abs(cur.val - k) < Math.abs(res - k)) {
                res = cur.val;
            }
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(4);
        // root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(9);
        root.right.right.right = new TreeNode(10);
        System.out.println(new Solution().findClosestLeaf(root, 4));
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}