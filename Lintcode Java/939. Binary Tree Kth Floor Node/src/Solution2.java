import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
    /**
     * @param root: the root node
     * @param k: an integer
     * @return: the number of nodes in the k-th layer of the binary tree
     */
    public int kthfloorNode(TreeNode root, int k) {
        // Write your code here
        if (root == null) {
            return 0;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int floor = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (floor == k) {
                return size;
            }
            for (int i = 0; i < size; i++) {
                TreeNode x = queue.poll();
                if (x.left != null) {
                    queue.offer(x.left);
                }
                if (x.right != null) {
                    queue.offer(x.right);
                }
            }
            floor++;
        }
        
        return 0;
    }
}
