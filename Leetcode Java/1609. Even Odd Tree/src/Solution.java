import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        int level = 0;
        List<Integer> row = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                
                if ((level % 2 == 0 && cur.val % 2 == 0) || (level % 2 != 0 && cur.val % 2 != 0)) {
                    return false;
                }
                
                if (!row.isEmpty()) {
                    int last = row.get(row.size() - 1);
                    if (level % 2 == 0 && cur.val <= last) {
                        return false;
                    } else if (level % 2 != 0 && cur.val >= last) {
                        return false;
                    }
                }
                
                row.add(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            
            level++;
            row.clear();
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
