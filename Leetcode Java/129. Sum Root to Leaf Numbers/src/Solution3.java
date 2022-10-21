public class Solution3 {
    private int sum = 0;
    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return sum;
    }

    public void dfs(TreeNode node, int num) {
        int val = 10 * num + node.val;
        if (isLeaf(node)) {
            sum += val;
            return;
        }
        if (node.left != null) {
            dfs(node.left, val);
        }
        if (node.right != null) {
            dfs(node.right, val);
        }
    }

    public boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}

