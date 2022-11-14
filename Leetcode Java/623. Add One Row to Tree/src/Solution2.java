import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (root == null) {
            return null;
        }
        if (depth == 1) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.offer(root);
        while (!q1.isEmpty() && depth >= 2) {
            while (!q1.isEmpty()) {
                TreeNode cur = q1.poll();
                if (cur.left != null) {
                    q2.offer(cur.left);
                }
                if (cur.right != null) {
                    q2.offer(cur.right);
                }
                if (depth == 2) {
                    TreeNode node1 = new TreeNode(val);
                    node1.left = cur.left;
                    cur.left = node1;
                    TreeNode node2 = new TreeNode(val);
                    node2.right = cur.right;
                    cur.right = node2;
                }
            }
            depth--;
            Queue<TreeNode> temp = q1;
            q1 = q2;
            q2 = temp;
        }
        return root;
    }
}

