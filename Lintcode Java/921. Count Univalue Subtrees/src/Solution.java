public class Solution {
    
    private int res;
    
    /**
     * @param root: the given tree
     * @return: the number of uni-value subtrees.
     */
    public int countUnivalSubtrees(TreeNode root) {
        // write your code here
        dfs(root);
        return res;
    }
    
    private boolean dfs(TreeNode cur) {
        if (cur == null) {
            return true;
        }
        
        boolean isUni = true;
        isUni &= dfs(cur.left);
        isUni &= dfs(cur.right);
        
        if (!isUni) {
            return false;
        }
        
        if (cur.left != null && cur.val != cur.left.val) {
            return false;
        }
        if (cur.right != null && cur.val != cur.right.val) {
            return false;
        }
        
        res++;
        return true;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(new Solution().countUnivalSubtrees(root));
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}