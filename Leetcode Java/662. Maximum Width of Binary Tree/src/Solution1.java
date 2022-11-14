import java.util.LinkedList;
import java.util.Queue;

public class Solution1 {
    private int h = 0;
    private long[] max;
    private long[] min;
    public int widthOfBinaryTree(TreeNode root) {
        dfs1(root, 0);
        int m = h + 1;
        max = new long[m];
        min = new long[m];
        for (int i = 0; i < m; i++) {
            max[i] = Long.MIN_VALUE;
            min[i] = Long.MAX_VALUE;
        }
        dfs2(root, 0, 1);
        int res = 0;
        for (int i = 0; i < m; i++) {
            res = Math.max(res, (int)(max[i] - min[i] + 1));
        }
        return res;
    }

    public void dfs1(TreeNode node, int d) {
        h = Math.max(h, d);
        if (node.left != null) {
            dfs1(node.left, d + 1);
        }
        if (node.right != null) {
            dfs1(node.right, d + 1);
        }
    }

    public void dfs2(TreeNode node, int i, long j) {
        max[i] = Math.max(max[i], j);
        min[i] = Math.min(min[i], j);
        if (node.left != null) {
            dfs2(node.left, i + 1, 2 * j);
        }
        if (node.right != null) {
            dfs2(node.right, i + 1, 2 * j + 1);
        }
    }
}

