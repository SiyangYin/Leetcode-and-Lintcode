import java.util.ArrayDeque;
import java.util.Deque;

public class BSTIterator {
    
    private Deque<TreeNode> stack;
    
    public BSTIterator(TreeNode root) {
        stack = new ArrayDeque<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }
    
    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode cur = stack.pop();
        int res = cur.val;
        if (cur.right != null) {
            cur = cur.right;
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
        }
        
        return res;
    }
    
    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    TreeNode(int x) {
        val = x;
    }
}