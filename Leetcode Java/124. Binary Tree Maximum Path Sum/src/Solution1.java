import java.util.HashMap;
import java.util.Map;

public class Solution1 {
    private Map<TreeNode, Integer> map = new HashMap<>();
    public int maxPathSum(TreeNode root) {
        dfs1(root);
        return dfs2(root);
    }

    public int dfs1(TreeNode node) {
        if (map.containsKey(node)) {
            return map.get(node);
        }
        if (node == null) {
            map.put(null, 0);
            return 0;
        }
        if (isLeaf(node)) {
            map.put(node, node.val);
            return node.val;
        }
        int max = node.val;
        max = Math.max(max, node.val + dfs1(node.left));
        max = Math.max(max, node.val + dfs1(node.right));
        map.put(node, max);
        return max;
    }

    public int dfs2(TreeNode node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }
        int res = node.val;
        if (node.left != null && map.containsKey(node.left)) {
            res = Math.max(res, res += map.get(node.left));
        }
        if (node.right != null && map.containsKey(node.right)) {
            res = Math.max(res, res += map.get(node.right));
        }
        res = Math.max(res, dfs2(node.left));
        res = Math.max(res, dfs2(node.right));
        return res;
    }

    public boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }
}

