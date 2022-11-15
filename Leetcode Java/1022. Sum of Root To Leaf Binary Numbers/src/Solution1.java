public class Solution1 {
    private int res = 0;
    public int sumRootToLeaf(TreeNode root) {
        dfs(root, root.val);
        return res;
    }

    public void dfs(TreeNode node, int sum) {
        if (node.left != null) {
            dfs(node.left, (sum << 1) + node.left.val);
        }
        if (node.right != null) {
            dfs(node.right, (sum << 1) + node.right.val);
        }
        if (node.left == null && node.right == null) {
            res += sum;
        }
    }
}

