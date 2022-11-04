public class Solution1 {
    private int cnt = 0;
    public int countNodes(TreeNode root) {
        dfs(root);
        return cnt;
    }

    public void dfs(TreeNode node) {
        if (node != null) {
            cnt++;
            dfs(node.left);
            dfs(node.right);
        }
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        
        System.out.println(new Solution1().countNodes(root));
    }
}

