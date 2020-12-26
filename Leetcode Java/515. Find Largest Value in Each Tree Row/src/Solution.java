import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        
        if (root == null) {
            return res;
        }
        
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size(), max = Integer.MIN_VALUE;
            
            for (int i = 0; i < size; i++) {
                TreeNode x = queue.poll();
                max = Math.max(max, x.val);
                if (x.left != null) {
                    queue.offer(x.left);
                }
                if(x.right != null) {
                    queue.offer(x.right);
                }
            }
            res.add(max);
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