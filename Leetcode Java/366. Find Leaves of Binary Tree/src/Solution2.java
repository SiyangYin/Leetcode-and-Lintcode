import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }
    
    private int dfs(TreeNode root, List<List<Integer>> res) {
        if (root == null) {
            return -1;
        }
        
        int height = 1 + Math.max(dfs(root.left, res), dfs(root.right, res));
        if (height >= res.size()) {
            res.add(new ArrayList<>());
        }
        
        res.get(height).add(root.val);
        return height;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(9);
        System.out.println(new Solution2().findLeaves(root));
    }
}
