import java.util.Arrays;

public class Solution {
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        if (x == 1) {
            return dfs(root.left) != dfs(root.right);
        }
        TreeNode node = find(root, x);
        int left = dfs(node.left);
        int right = dfs(node.right);
        return left > (n - 1) / 2 || right > (n - 1) / 2 || left + right < (n - 1) / 2;
    }

    public TreeNode find(TreeNode root, int x) {
        if (root == null || root.val == x) {
            return root;
        }
        TreeNode left = find(root.left, x);
        if (left != null) {
            return left;
        }
        else {
            return find(root.right, x);
        }
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + dfs(node.left) + dfs(node.right);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}