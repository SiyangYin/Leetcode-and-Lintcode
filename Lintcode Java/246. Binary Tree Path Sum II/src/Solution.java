import java.util.ArrayList;
import java.util.List;

public class Solution {
    /*
     * @param root: the root of binary tree
     * @param target: An integer
     * @return: all valid paths
     */
    public List<List<Integer>> binaryTreePathSum2(TreeNode root, int target) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        
        List<Integer> cur = new ArrayList<>();
        cur.add(root.val);
        
        dfs(root, target, cur, res);
        return res;
    }
    
    private void dfs(TreeNode root, int target, List<Integer> cur, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        
        int sum = 0;
        for (int i = cur.size() - 1; i >= 0; i--) {
            sum += cur.get(i);
            if (sum == target) {
                res.add(new ArrayList<>(cur.subList(i, cur.size())));
            }
        }
        
        if (root.left != null) {
            cur.add(root.left.val);
            dfs(root.left, target, cur, res);
            cur.remove(cur.size() - 1);
        }
    
        if (root.right != null) {
            cur.add(root.right.val);
            dfs(root.right, target, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
    
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
    
        System.out.println(new Solution().binaryTreePathSum2(root, 6));
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}