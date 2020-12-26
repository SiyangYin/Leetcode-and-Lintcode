import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    /**
     * @param root: A Tree
     * @return: Postorder in ArrayList which contains node values.
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        list.addAll(postorderTraversal(root.left));
        list.addAll(postorderTraversal(root.right));
        list.add(root.val);
        return list;
    }
    
    public List<Integer> postorderTraversal2(TreeNode root) {
        // write your code here
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return list;
        }
        TreeNode curNode = root;
        while (true) {
            visitAlongLeftBranch(curNode, stack, list);
            if (stack.isEmpty()) {
                break;
            }
            TreeNode x = stack.pop();
            if (x.right == null) {
                list.add(x.val);
            }
            curNode = x.right;
        }
        return list;
    }
    
    public static void visitAlongLeftBranch(TreeNode root, Stack<TreeNode> stack, List<Integer> list) {
        TreeNode curNode = root;
        while (curNode != null) {
            stack.push(curNode);
            curNode = curNode.left;
        }
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(4);
        // 3 2 4 1
        System.out.println(new Solution().postorderTraversal(root));
        System.out.println(new Solution().postorderTraversal2(root));
        
    }
}