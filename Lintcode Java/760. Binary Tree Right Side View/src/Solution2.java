import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    /**
     * @param root: the root of the given tree
     * @return: the values of the nodes you can see ordered from top to bottom
     */
    public List<Integer> rightSideView(TreeNode root) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }
    
    private void dfs(TreeNode root, int depth, List<Integer> res) {
        if (root == null) {
            return;
        }
        
        if (depth == res.size()) {
            res.add(root.val);
        } else {
            res.set(depth, root.val);
        }
        
        dfs(root.left, depth + 1, res);
        dfs(root.right, depth + 1, res);
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        System.out.println(new Solution2().rightSideView(root));
    }
}
