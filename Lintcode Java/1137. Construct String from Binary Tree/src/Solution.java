public class Solution {
    /**
     * @param root: the root of tree
     * @return: return a string
     */
    public String tree2str(TreeNode root) {
        // write your code here
        return dfs(root).toString();
    }
    
    private StringBuilder dfs(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        
        if (root == null) {
            return sb;
        }
        
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            return sb;
        }
        
        sb.append('(').append(dfs(root.left)).append(')');
        if (root.right != null) {
            sb.append('(').append(dfs(root.right)).append(')');
        }
        
        return sb;
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}