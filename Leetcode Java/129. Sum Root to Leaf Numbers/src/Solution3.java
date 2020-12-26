public class Solution3 {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return sum(root, root.val);
    }
    
    private int sum(TreeNode root, int cur){
        // if (root == null) {
        //     return 0;
        // }
        
        if (root.left == null && root.right == null) {
            return cur;
        }
        
        int sum = 0;
        if (root.left != null) {
            sum += sum(root.left, cur * 10 + root.left.val);
        }
        if (root.right != null) {
            sum += sum(root.right, cur * 10 + root.right.val);
        }
        return sum;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(0);
        System.out.println(new Solution3().sumNumbers(root));
    }
}
