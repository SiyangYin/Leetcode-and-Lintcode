import java.util.HashSet;
import java.util.Set;

public class FindElements1 {
    private Set<Integer> set;
    public FindElements1(TreeNode root) {
        set = new HashSet<>();
        root.val = 0;
        set.add(0);
        dfs(root);
    }

    public void dfs(TreeNode node) {
        if (node.left != null) {
            node.left.val = 2 * node.val + 1;
            set.add(node.left.val);
            dfs(node.left);
        }
        if (node.right != null) {
            node.right.val = 2 * node.val + 2;
            set.add(node.right.val);
            dfs(node.right);
        }
    }

    public boolean find(int target) {
        return set.contains(target);
    }
}

