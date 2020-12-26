public class Solution {
    
    private int idx;
    
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        
        // idx = 0;
        return dfs(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private TreeNode dfs(int[] preorder, int min, int max) {
        if (idx == preorder.length) {
            return null;
        }
        
        int val = preorder[idx];
        if (min < val && val < max) {
            TreeNode root = new TreeNode(val);
            idx++;
            root.left = dfs(preorder, min, val);
            root.right = dfs(preorder, val, max);
            return root;
        } else {
            return null;
        }
    }
    
    public static void main(String[] args) {
        TreeNode treeNode = new Solution().bstFromPreorder(new int[]{8, 5, 1, 7});
        treeNode = new Solution().bstFromPreorder(new int[]{8, 5, 1, 7, 10, 12});
        
        System.out.println();
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}