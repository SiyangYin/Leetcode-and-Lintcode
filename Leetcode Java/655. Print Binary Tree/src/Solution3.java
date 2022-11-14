import java.util.ArrayList;
import java.util.List;

public class Solution3 {
    private List<List<String>> res = new ArrayList<>();
    private int h = 0;
    public List<List<String>> printTree(TreeNode root) {
        dfs1(root, 0);
        int m = h + 1;
        int n = (1 << h + 1) - 1;
        for (int i = 0; i < m; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                list.add("");
            }
            res.add(list);
        }
        dfs2(root, 0, 0, n - 1);
        return res;
    }

    public void dfs1(TreeNode node, int d) {
        if (d > h) {
            h = d;
        }
        if (node.left != null) {
            dfs1(node.left, d + 1);
        }
        if (node.right != null) {
            dfs1(node.right, d + 1);
        }
    }

    public void dfs2(TreeNode node, int i, int l, int r) {
        int m = l + r >> 1;
        res.get(i).set(m, String.valueOf(node.val));
        if (node.left != null) {
            dfs2(node.left, i + 1, l, m);
        }
        if (node.right != null) {
            dfs2(node.right, i + 1, m + 1 , r);
        }
    }
}

