import java.util.HashMap;

public class Solution2 {
    public boolean isBalanced(TreeNode root) {
        HashMap<TreeNode, Integer> memo = new HashMap<>();
        memo.put(null, 0);
        
        return helper(root, memo);
    }
    
    private boolean helper(TreeNode root, HashMap<TreeNode, Integer> memo) {
        if (root == null) {
            return true;
        }
        
        return helper(root.left, memo) &&
                helper(root.right, memo) &&
                Math.abs(height(root.left, memo) - height(root.right, memo)) <= 1;
        
    }
    
    private int height(TreeNode root, HashMap<TreeNode, Integer> memo) {
        if (memo.containsKey(root)) {
            System.out.println("yeah");
            return memo.get(root);
        } else {
            int res = Math.max(height(root.left, memo), height(root.right, memo)) + 1;
            memo.put(root, res);
            return res;
        }
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.right = new TreeNode(15);
        root.right.right.left = new TreeNode(7);
        root.right.right.right = new TreeNode(5);
        
        System.out.println(new Solution2().isBalanced(root));
    }
}
