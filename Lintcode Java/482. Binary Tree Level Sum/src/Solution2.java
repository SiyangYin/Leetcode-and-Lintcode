import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
    /**
     * @param root:  the root of the binary tree
     * @param level: the depth of the target level
     * @return: An integer
     */
    public int levelSum(TreeNode root, int level) {
        // write your code here
        if (root == null) {
            return 0;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int cur = 1, res = 0;
        while (!queue.isEmpty() && cur <= level) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode x = queue.poll();
                if (cur == level) {
                    res += x.val;
                } else {
                    if (x.left != null) {
                        queue.offer(x.left);
                    }
                    if (x.right != null) {
                        queue.offer(x.right);
                    }
                }
            }
            cur++;
        }
        
        return res;
    }
}
