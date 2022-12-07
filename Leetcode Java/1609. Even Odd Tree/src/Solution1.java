import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution1 {
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.offer(root);
        int i = 0;
        while (!q1.isEmpty()) {
            TreeNode prev = null;
            if (!q1.isEmpty()) {
                prev = q1.poll();
                if (i % 2 == 0 && prev.val % 2 == 0) {
                    return false;
                }
                else if (i % 2 == 1 && prev.val % 2 == 1) {
                    return false;
                }
                if (prev.left != null) {
                    q2.offer(prev.left);
                }
                if (prev.right != null) {
                    q2.offer(prev.right);
                }
            }
            while (!q1.isEmpty()) {
                TreeNode node = q1.poll();
                if (i % 2 == 0 && (node.val % 2 == 0 || node.val <= prev.val)) {
                    return false;
                }
                else if (i % 2 == 1 && (node.val % 2 == 1 || node.val >= prev.val)) {
                    return false;
                }
                prev = node;
                if (node.left != null) {
                    q2.offer(node.left);
                }
                if (node.right != null) {
                    q2.offer(node.right);
                }
            }
            Queue<TreeNode> temp = q1;
            q1 = q2;
            q2 = temp;
            i++;
        }
        return true;
    }
}

