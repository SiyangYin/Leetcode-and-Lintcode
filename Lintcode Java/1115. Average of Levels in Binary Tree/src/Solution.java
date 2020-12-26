import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    /**
     * @param root: the binary tree of the  root
     * @return: return a list of double
     */
    public List<Double> averageOfLevels(TreeNode root) {
        // write your code here
        List<Double> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            double avg = 0;
            for (int i = 0; i < size; i++) {
                TreeNode x = queue.poll();
                avg += x.val;
                if (x.left != null) {
                    queue.offer(x.left);
                }
                if (x.right != null) {
                    queue.offer(x.right);
                }
            }
            
            res.add(avg / size);
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