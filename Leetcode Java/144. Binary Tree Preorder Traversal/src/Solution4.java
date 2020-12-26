import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution4 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            System.out.println(stack.size());
            TreeNode x = stack.pop();
            res.add(x.val);
            if (x.right != null) {
                stack.push(x.right);
            }
            if (x.left != null) {
                stack.push(x.left);
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(4);
        root.left.left.left.right = new TreeNode(4);
        root.right = new TreeNode(3);
        System.out.println(new Solution4().preorderTraversal(root));
    }
}
