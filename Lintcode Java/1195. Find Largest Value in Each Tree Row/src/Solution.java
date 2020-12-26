import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    /**
     * @param root: a root of integer
     * @return: return a list of integer
     */
    public List<Integer> largestValues(TreeNode root) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode x = queue.poll();
                max = Math.max(max, x.val);
                if (x.left != null) {
                    queue.offer(x.left);
                }
                if (x.right != null) {
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