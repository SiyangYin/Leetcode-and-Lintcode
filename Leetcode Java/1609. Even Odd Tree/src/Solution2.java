import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int i = 0;
        while (!q.isEmpty()) {
            TreeNode prev = null;
            int size = q.size();
            if (!q.isEmpty()) {
                prev = q.poll();
                if (i % 2 == 0 && prev.val % 2 == 0) {
                    return false;
                }
                else if (i % 2 == 1 && prev.val % 2 == 1) {
                    return false;
                }
                if (prev.left != null) {
                    q.offer(prev.left);
                }
                if (prev.right != null) {
                    q.offer(prev.right);
                }
            }
            for (int j = 0; j < size - 1; j++) {
                TreeNode node = q.poll();
                if (i % 2 == 0 && (node.val % 2 == 0 || node.val <= prev.val)) {
                    return false;
                }
                else if (i % 2 == 1 && (node.val % 2 == 1 || node.val >= prev.val)) {
                    return false;
                }
                prev = node;
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            i++;
        }
        return true;
    }
}

