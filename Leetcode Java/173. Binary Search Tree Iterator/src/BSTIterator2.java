import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BSTIterator2 {
    private Deque<Integer> stack;
    public BSTIterator2(TreeNode root) {
        stack = new ArrayDeque<>();
        dfs(root);
    }

    public int next() {
        return stack.pop();
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public void dfs(TreeNode node) {
        if (node != null) {
            dfs(node.right);
            stack.push(node.val);
            dfs(node.left);
        }
    }
}

