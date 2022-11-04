import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    private List<Integer> list = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        dfs(root);
        return list.get(k - 1);
    }

    public void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.left);
        list.add(node.val);
        dfs(node.right);
    }
}

