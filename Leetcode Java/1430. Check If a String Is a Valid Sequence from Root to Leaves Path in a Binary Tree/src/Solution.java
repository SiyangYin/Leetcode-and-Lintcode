public class Solution {
    public boolean isValidSequence(TreeNode root, int[] arr) {
        return dfs(0, root, arr);
    }
    
    private boolean dfs(int pos, TreeNode cur, int[] A) {
        if (cur == null) {
            return false;
        }
    
        if (pos == A.length) {
            return false;
        }
    
        if (cur.val != A[pos]) {
            return false;
        }
        
        if (cur.left == null && cur.right == null) {
            return pos == A.length - 1;
        }
        
        return dfs(pos + 1, cur.left, A) || dfs(pos + 1, cur.right, A);
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(1);
    
        System.out.println(new Solution().isValidSequence(root, new int[]{8}));
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}