public class Solution {
    
    TreeNode minRoot = null;
    int minSum = Integer.MAX_VALUE;
    
    /**
     * @param root: the root of binary tree
     * @return: the root of the minimum subtree
     */
    public TreeNode findSubtree(TreeNode root) {
        // write your code here
        dfs(root);
        
        return minRoot;
    }
    
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int leftSum = dfs(root.left), rightSum = dfs(root.right);
        int subSum = leftSum + rightSum + root.val;
        
        if (minSum > leftSum + rightSum + root.val) {
            minSum = leftSum + rightSum + root.val;
            minRoot = root;
        }
        
        return subSum;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-5);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(-4);
        root.right.right = new TreeNode(-5);
    
        System.out.println(root);
        System.out.println(new Solution().findSubtree(root));
        
        int a = 3, b = 6, c = a + b;
        System.out.println(c);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}