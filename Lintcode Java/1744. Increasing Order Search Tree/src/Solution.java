import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    /**
     * @param root: a binary search tree
     * @return: Root of a tree
     */
    public TreeNode increasingBST(TreeNode root) {
        // Write your code here.
        if (root == null) {
            return null;
        }
        
        TreeNode dummy = new TreeNode(0), prev = dummy;
        Deque<TreeNode> stack = new LinkedList<>();
        
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            
            cur = stack.pop();
            prev.right = cur;
            prev = prev.right;
            
            cur = cur.right;
        }
        
        prev = dummy.right;
        while (prev != null) {
            prev.left = null;
            prev = prev.right;
        }
        
        return dummy.right;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        TreeNode res = new Solution().increasingBST(root);
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