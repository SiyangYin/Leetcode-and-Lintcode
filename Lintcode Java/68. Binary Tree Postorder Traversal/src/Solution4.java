import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution4 {
    public List<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        
        Deque<TreeNode> stack = new LinkedList<>();
        System.out.println(stack.getClass());
        stack.push(root);
        TreeNode cur = root;
        
        TreeNode prev = null;
        while (!stack.isEmpty()) {
            cur = stack.peek();
            if (prev == null || cur == prev.left || cur == prev.right) {
                if (cur.left != null) {
                    stack.push(cur.left);
                } else if (cur.right != null) {
                    stack.push(cur.right);
                } else {
                    res.add(cur.val);
                    stack.pop();
                }
            } else if (prev == cur.left) {
                if (cur.right != null) {
                    stack.push(cur.right);
                } else {
                    res.add(cur.val);
                    stack.pop();
                }
            } else {
                res.add(cur.val);
                stack.pop();
            }
            
            prev = cur;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(4);
        // 3 2 4 1
        System.out.println(new Solution4().postorderTraversal(root));
    }
}
