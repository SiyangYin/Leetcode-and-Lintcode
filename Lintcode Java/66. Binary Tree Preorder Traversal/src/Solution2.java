import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        ArrayList<Integer> left = (ArrayList<Integer>) preorderTraversal(root.left);
        ArrayList<Integer> right = (ArrayList<Integer>) preorderTraversal(root.right);
        list.add(root.val);
        list.addAll(left);
        list.addAll(right);
        return list;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(4);
        System.out.println(new Solution().preorderTraversal(root));
    }
}
