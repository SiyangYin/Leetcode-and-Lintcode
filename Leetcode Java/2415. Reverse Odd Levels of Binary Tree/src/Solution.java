import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int i = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        while (!q.isEmpty()) {
            int size = q.size();
            for (int j = 0; j < size; j++) {
                TreeNode node = q.poll();
                if (i % 2 == 1) {
                    node.val = stack.pop();
                }
                else if (!isLeaf(node)) {
                    stack.push(node.left.val);
                    stack.push(node.right.val);
                }
                if (!isLeaf(node)) {
                    q.offer(node.left);
                    q.offer(node.right);
                }
            }
            i++;
        }
        return root;
    }

    public boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}

class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
    }
}