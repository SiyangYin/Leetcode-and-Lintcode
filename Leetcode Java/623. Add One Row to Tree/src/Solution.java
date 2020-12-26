import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        int depth = 1;
        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (depth == d) {
                    TreeNode left = cur.left, right = cur.right;
                    cur.left = new TreeNode(v);
                    cur.left.left = left;
                    cur.right = new TreeNode(v);
                    cur.right.right = right;
                }
                
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            
            if (depth == d) {
                break;
            }
        }
        
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}