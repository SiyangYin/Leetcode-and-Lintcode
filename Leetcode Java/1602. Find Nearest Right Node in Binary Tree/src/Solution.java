import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
        if (root == null || u == null) {
            return null;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        boolean flag = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                
                if (flag) {
                    return cur;
                }
                if (cur == u) {
                    flag = true;
                    continue;
                }
                
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            
            if (flag) {
                return null;
            }
        }
        
        return null;
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}