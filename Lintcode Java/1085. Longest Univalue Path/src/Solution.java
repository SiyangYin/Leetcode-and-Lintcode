public class Solution {
    
    private int res;
    
    /**
     * @param root:
     * @return: the length of the longest path where each node in the path has the same value
     */
    public int longestUnivaluePath(TreeNode root) {
        // Write your code here
        dfs(root);
        return res - 1;
    }
    
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int len = 1, ans = 1;
        int left = dfs(root.left), right = dfs(root.right);
        if (root.left != null && root.left.val == root.val) {
            len += left;
            ans = Math.max(ans, 1 + left);
        }
        if (root.right != null && root.right.val == root.val) {
            len += right;
            ans = Math.max(ans, 1 + right);
        }
        
        res = Math.max(res, len);
        return ans;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(4);
        root.right.right = new TreeNode(4);
        
        System.out.println(new Solution().longestUnivaluePath(root));
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}