public class Solution {
    
    private int res;
    
    /**
     * @param root: the root of binary tree
     * @return: the length of the longest consecutive sequence path
     */
    public int longestConsecutive(TreeNode root) {
        // write your code here
        res = 0;
        dfs(root);
        
        return res;
    }
    
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int len = 1;
        int left = dfs(root.left), right = dfs(root.right);
        if (root.left != null && root.left.val - root.val == 1) {
            len = Math.max(len, 1 + left);
        }
        if (root.right != null && root.right.val - root.val == 1) {
            len = Math.max(len, 1 + right);
        }
        
        res = Math.max(res, len);
        return len;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(5);
        root.right.right.right.right = new TreeNode(1);
        root.right.right.left = new TreeNode(3);
        System.out.println(new Solution().longestConsecutive(root));
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}
