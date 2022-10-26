import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BSTIterator1 {
    private List<Integer> list;
    private int p;
    public BSTIterator1(TreeNode root) {
        list = new ArrayList<>();
        dfs(root);
        p = 0;
    }

    public int next() {
        return list.get(p++);
    }

    public boolean hasNext() {
        return list.size() > p;
    }

    public void dfs(TreeNode node) {
        if (node != null) {
            dfs(node.left);
            list.add(node.val);
            dfs(node.right);
        }
    }
}

