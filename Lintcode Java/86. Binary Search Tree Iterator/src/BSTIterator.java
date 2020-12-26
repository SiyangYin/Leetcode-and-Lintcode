import java.util.ArrayDeque;
import java.util.Deque;

public class BSTIterator {
    
    Deque<TreeNode> stack;
    TreeNode cur;
    
    /*
     * @param root: The root of binary tree.
     */
    public BSTIterator(TreeNode root) {
        // do intialization if necessary
        stack = new ArrayDeque<>();
        cur = root;
    }
    
    /*
     * @return: True if there has next node, or false
     */
    public boolean hasNext() {
        // write your code here
        return cur != null || !stack.isEmpty();
    }
    
    /*
     * @return: return next node
     */
    public TreeNode next() {
        // write your code here
        if (cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
        }
        
        cur = stack.peek().right;
        return stack.pop();
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.right = new TreeNode(11);
        root.right.right = new TreeNode(12);
        
        BSTIterator it = new BSTIterator(root);
        while (it.hasNext()) {
            TreeNode cur = it.next();
            System.out.println(cur.val);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    TreeNode(int x) {
        val = x;
    }
}
