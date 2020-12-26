import java.util.Deque;
import java.util.LinkedList;

public class Solution2 {
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);
        
        for (int i = 1; i < preorder.length; i++) {
            if (preorder[i] < stack.peek().val) {
                stack.peek().left = new TreeNode(preorder[i]);
                stack.push(stack.peek().left);
            } else {
                TreeNode cur = null;
                while (!stack.isEmpty() && stack.peek().val < preorder[i]) {
                    cur = stack.pop();
                }
                
                cur.right = new TreeNode(preorder[i]);
                stack.push(cur.right);
            }
        }
        
        return root;
    }
    
    public static void main(String[] args) {
        TreeNode root = new Solution2().bstFromPreorder(new int[]{8, 5, 1, 7, 10, 12});
        System.out.println(root);
    }
}
