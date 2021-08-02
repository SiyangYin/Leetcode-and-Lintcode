public class Solution {
    
    private int res;
    
    public int maxSumBST(TreeNode root) {
        dfs(root);
        return res;
    }
    
    private int[] dfs(TreeNode cur) {
        if (cur == null) {
            return null;
        }
        
        int[] left = dfs(cur.left), right = dfs(cur.right);
        int[] info = {1, cur.val, cur.val, cur.val};
        if (left != null && (left[3] >= cur.val || left[0] == 0) || right != null && (right[2] <= cur.val || right[0] == 0)) {
            info[0] = 0;
            return info;
        }
        
        info[1] += (left != null ? left[1] : 0) + (right != null ? right[1] : 0);
        if (left != null) {
            info[2] = left[2];
        }
        if (right != null) {
            info[3] = right[3];
        }
    
        res = Math.max(res, info[1]);
        return info;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(5);
        root.right.right.left = new TreeNode(4);
        root.right.right.right = new TreeNode(6);
        System.out.println(new Solution().maxSumBST(root));
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}