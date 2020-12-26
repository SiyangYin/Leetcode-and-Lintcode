import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    /**
     * @param root: root of a tree
     * @return: head node of a doubly linked list
     */
    public TreeNode treeToDoublyList(TreeNode root) {
        // Write your code here.
        if (root == null) {
            return null;
        }
        
        Deque<TreeNode> stack = new LinkedList<>();
        
        TreeNode dummy = new TreeNode(0), prev = dummy;
        TreeNode cur = root, last = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            
            cur = stack.pop();
            prev.right = cur;
            cur.left = prev;
            last = cur;
            
            prev = prev.right;
            cur = cur.right;
        }
        
        last.right = dummy.right;
        dummy.right.left = last;
        
        return dummy.right;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        // root.left = new TreeNode(2);
        // root.left.left = new TreeNode(1);
        // root.left.right = new TreeNode(3);
        // root.right = new TreeNode(5);
    
        TreeNode res = new Solution().treeToDoublyList(root);
        System.out.println(res);
    
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}