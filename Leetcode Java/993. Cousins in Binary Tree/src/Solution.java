import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null || root.val == x || root.val == y) {
            return false;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Set<Integer> set = new HashSet<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null && cur.right != null) {
                    if ((cur.left.val == x && cur.right.val == y) || (cur.left.val == y && cur.right.val == x)) {
                        return false;
                    }
                }
                
                if (cur.left != null) {
                    queue.offer(cur.left);
                    set.add(cur.left.val);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                    set.add(cur.right.val);
                }
                if (set.contains(x) && set.contains(y)) {
                    return true;
                }
            }
        }
        
        return false;
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    TreeNode(int x) {
        val = x;
    }
}
