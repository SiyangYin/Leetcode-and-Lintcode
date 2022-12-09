public class Solution {
    private int cnt = 0;
    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return cnt;
    }

    public int[] dfs(TreeNode node) {
        int[] cur = new int[2];
        if (node != null) {
            int[] left = dfs(node.left);
            int[] right = dfs(node.right);
            cur[0] = left[0] + right[0] + 1;
            cur[1] = left[1] + right[1] + node.val;
            if (cur[1] / cur [0] == node.val) {
                cnt++;
            }
        }
        return cur;
    }
}

class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
    }
}