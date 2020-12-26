import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    /**
     * @param root: the root
     * @return: the minimum difference between the values of any two different nodes in the tree
     */
    public int minDiffInBST(TreeNode root) {
        // Write your code here
        int res = Integer.MAX_VALUE;
        
        TreeNode cur = root, last = null;
        Deque<TreeNode> stack = new LinkedList<>();
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
    
            cur = stack.pop();
            
            if (last != null) {
                res = Math.min(res, cur.val - last.val);
            }
            
            last = cur;
            cur = cur.right;
        }
        
        return res;
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}
