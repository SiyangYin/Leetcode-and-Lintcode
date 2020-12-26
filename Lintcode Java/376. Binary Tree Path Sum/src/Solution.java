import java.util.ArrayList;
import java.util.List;

public class Solution {
    /*
     * @param root: the root of binary tree
     * @param target: An integer
     * @return: all valid paths
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<Integer> cur = new ArrayList<>();
        cur.add(root.val);
        dfs(root, target, root.val, cur, res);
        return res;
    }
    
    private void dfs(TreeNode root, int target, int sum, List<Integer> cur, List<List<Integer>> res) {
        if (root != null && root.left == null && root.right == null && target == sum) {
            res.add(new ArrayList<>(cur));
            return;
        }
        
        if (root.left != null) {
            cur.add(root.left.val);
            dfs(root.left, target, sum + root.left.val, cur, res);
            cur.remove(cur.size() - 1);
        }
        if (root.right != null) {
            cur.add(root.right.val);
            dfs(root.right, target, sum + root.right.val, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
    
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(4);
    
        System.out.println(new Solution().binaryTreePathSum(root, 5));
    }
}

class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}