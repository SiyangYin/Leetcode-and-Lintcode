public class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        
        int res = findPath(root, sum);
        res += pathSum(root.left, sum);
        res += pathSum(root.right, sum);
        
        return res;
    }
    
    // 返回从root出发，和为num的路径个数
    private int findPath(TreeNode root, int num) {
        if (root == null) {
            return 0;
        }
        
        int res = 0;
        if (root.val == num) {
            res += 1;
        }
        
        res += findPath(root.left, num - root.val);
        res += findPath(root.right, num - root.val);
        
        return res;
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
    
        System.out.println(new Solution().pathSum(root, 8));
    }
}

