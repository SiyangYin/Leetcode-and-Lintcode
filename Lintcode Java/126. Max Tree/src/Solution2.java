import java.util.Deque;
import java.util.LinkedList;

public class Solution2 {
    /**
     * @param A: Given an integer array with no duplicates.
     * @return: The root of max tree.
     */
    public TreeNode maxTree(int[] A) {
        // write your code here
        Deque<TreeNode> stack = new LinkedList<>();
        for (int i = 0; i < A.length; i++) {
            if (stack.isEmpty()) {
                stack.push(new TreeNode(A[i]));
            } else {
                TreeNode last = null;
                while (!stack.isEmpty() && stack.peek().val < A[i]) {
                    last = stack.pop();
                }
                
                TreeNode cur = new TreeNode(A[i]);
                cur.left = last;
                if (!stack.isEmpty()) {
                    stack.peek().right = cur;
                }
                
                stack.push(cur);
            }
        }
        
        // while (stack.size() > 1) {
        //     stack.pop();
        // }
        // return stack.peek();
        return stack.peekLast();
    }
    
    public static void main(String[] args) {
        int[] A = {2, 5, 6, 0, 3, 1};
        TreeNode root = new Solution2().maxTree(A);
        
        System.out.println(root);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}