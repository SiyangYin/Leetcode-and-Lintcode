public class Solution3 {
    private int cnt;
    public int pathSum(TreeNode root, int targetSum) {
        cnt = 0;
        dfs(root, targetSum, false);
        return cnt;
    }

    public void dfs(TreeNode root, int targetSum, boolean use) {
        if (root == null) {
            return;
        }
        else if (root.val == targetSum) {
            cnt++;
        }
        if (!use) {
            dfs(root.left, targetSum, false);
            dfs(root.right, targetSum, false);
        }
        if (targetSum >= 0 && root.val < 0 && targetSum - root.val < 0 || targetSum < 0 && root.val >= 0 && targetSum - root.val >= 0) {
            return;
        }
        dfs(root.left, targetSum - root.val, true);
        dfs(root.right, targetSum - root.val, true);
    }
    
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
    
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);
    
        System.out.println(new Solution3().pathSum(root, 8));
    }
}

