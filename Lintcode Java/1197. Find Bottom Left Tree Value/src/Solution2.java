public class Solution2 {
    /**
     * @param root: a root of tree
     * @return: return a integer
     */
    public int findBottomLeftValue(TreeNode root) {
        // write your code here
        return dfs(root, 1)[0];
    }
    
    private int[] dfs(TreeNode root, int depth) {
        if (root == null) {
            return new int[]{0, Integer.MIN_VALUE};
        }
        
        if (root.left == null && root.right == null) {
            return new int[]{root.val, depth};
        }
        
        int[] left = dfs(root.left, depth + 1), right = dfs(root.right, depth + 1);
        if (left[1] != right[1]) {
            return left[1] > right[1] ? left : right;
        } else {
            return left;
        }
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        
        System.out.println(new Solution2().findBottomLeftValue(root));
    }
}
