public class Solution {
    
    double maxAve = -Double.MAX_VALUE;
    TreeNode ans = null;
    /**
     * @param root: the root of binary tree
     * @return: the root of the maximum average of subtree
     */
    public TreeNode findSubtree2(TreeNode root) {
        // write your code here
        if (root == null) {
            return root;
        }
        
        dfs(root);
        return ans;
    }
    
    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        
        int[] res = new int[2];
        int[] left = dfs(root.left), right = dfs(root.right);
        res[0] = left[0] + right[0] + 1;
        res[1] = left[1] + right[1] + root.val;
        
        double ave = (double) res[1] / res[0];
        if (ave > maxAve) {
            maxAve = ave;
            ans = root;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-1);
    
        System.out.println(new Solution().findSubtree2(root).val);
    }
    
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}