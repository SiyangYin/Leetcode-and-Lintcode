import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    private List<List<String>> res = new ArrayList<>();
    private int h = 0;
    public List<List<String>> printTree(TreeNode root) {
        dfs1(root, 0);
        for (int i = 0; i < h + 1; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < (1 << h + 1) - 1; j++) {
                list.add("");
            }
            res.add(list);
        }
        dfs2(root, 0, (res.get(0).size() - 1) / 2);
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

    public void dfs2(TreeNode node, int r, int c) {
        res.get(r).set(c, String.valueOf(node.val));
        if (node.left != null) {
            dfs2(node.left, r + 1, c - (1 << h - r - 1));
        }
        if (node.right != null) {
            dfs2(node.right, r + 1, c + (1 << h - r - 1));
        }
    }
}

