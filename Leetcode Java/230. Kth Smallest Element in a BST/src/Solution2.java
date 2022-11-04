import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    private List<Integer> list = new ArrayList<>();
    private int cnt = 0;
    private int res = 0;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return res;
    }

    public void dfs(TreeNode node, int k) {
        if (node == null) return;
        dfs(node.left, k);
        cnt++;
        if (cnt == k) {
            res = node.val;
            return;
        }
        dfs(node.right, k);
    }
}

