import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    /**
     * @param root: the root
     * @return: the minimum absolute difference between values of any two nodes
     */
    public int getMinimumDifference(TreeNode root) {
        // Write your code here
        int res = Integer.MAX_VALUE, x = -1;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            
            cur = stack.pop();
            if (x != -1) {
                res = Math.min(res, cur.val - x);
            }
            
            x = cur.val;
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