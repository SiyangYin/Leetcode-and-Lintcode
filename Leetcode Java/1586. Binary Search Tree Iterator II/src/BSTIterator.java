import java.util.ArrayDeque;
import java.util.Deque;

public class BSTIterator {
    
    private Deque<TreeNode> stack, buffer;
    
    public BSTIterator(TreeNode root) {
        stack = new ArrayDeque<>();
        buffer = new ArrayDeque<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    
    public int next() {
        return 0;
    }
    
    public boolean hasPrev() {
        return false;
    }
    
    public int prev() {
        return 0;
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}
