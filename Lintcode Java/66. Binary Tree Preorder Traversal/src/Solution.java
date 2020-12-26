import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class Solution {
    /**
     * @param root: A Tree
     * @return: Preorder in ArrayList which contains node values.
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> list = new ArrayList<>();
        preorderTraverse(root, list);
        return list;
    }
    
    
    // 把root为根的preorder加入list
    public void preorderTraverse(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preorderTraverse(root.left, list);
        preorderTraverse(root.right, list);
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(4);
        System.out.println(new Solution().preorderTraversal(root));
    }
}

