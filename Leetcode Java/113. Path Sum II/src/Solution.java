import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        
        if (root == null) {
            return res;
        }
        List<Integer> cur = new ArrayList<>();
        cur.add(root.val);
        
        dfs(root, root.val, sum, cur, res);
        return res;
    }
    
    public void dfs(TreeNode root, int sum, int target, List<Integer> cur,
                              List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        
        if (root.left == null && root.right == null && sum == target) {
            res.add(new ArrayList<>(cur));
            return;
        }
        
        if (root.left != null) {
            cur.add(root.left.val);
            dfs(root.left, sum + root.left.val, target, cur, res);
            cur.remove(cur.size() - 1);
        }
        if (root.right != null) {
            cur.add(root.right.val);
            dfs(root.right, sum + root.right.val, target, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        System.out.println(new Solution().pathSum(root, 22));
    }
}
