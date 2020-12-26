public class Solution {
    public String tree2str(TreeNode root) {
        if (root == null) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString();
    }
    
    private void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        
        if (root.left == null && root.right == null) {
            sb.append(root.val);
            return;
        }
        
        sb.append(root.val).append('(');
        dfs(root.left, sb);
        sb.append(')');
        if (root.right != null) {
            sb.append('(');
            dfs(root.right, sb);
            sb.append(')');
        }
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(3);
        System.out.println(new Solution().tree2str(root));
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}
