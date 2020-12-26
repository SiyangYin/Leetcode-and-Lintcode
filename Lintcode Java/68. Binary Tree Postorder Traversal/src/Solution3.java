import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution3 {
    public List<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                if (cur.left != null) {
                    cur = cur.left;
                } else {
                    cur = cur.right;
                }
            }
            
            cur = stack.pop();
            res.add(cur.val);
            
            if (!stack.isEmpty() && cur == stack.peek().left) {
                cur = stack.peek().right;
            } else {
                cur = null;
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(4);
        // 3 2 4 1
        System.out.println(new Solution3().postorderTraversal(root));
        
    }
}
