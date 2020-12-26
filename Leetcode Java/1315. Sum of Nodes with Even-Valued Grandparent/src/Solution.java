public class Solution {
    public int sumEvenGrandparent(TreeNode root) {
        return dfs(root, 0, root, root);
    }
    
    private int dfs(TreeNode cur, int depth, TreeNode parent, TreeNode grandParent) {
        if (cur == null) {
            return 0;
        }
        
        int sum = 0;
        if (depth >= 2 && grandParent.val % 2 == 0) {
            sum += cur.val;
        }
        
        sum += dfs(cur.left, depth + 1, cur, parent);
        sum += dfs(cur.right, depth + 1, cur, parent);
        
        return sum;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(7);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(3);
        root.left.left.left = new TreeNode(9);
        root.right.right.right = new TreeNode(5);
        
        System.out.println(new Solution().sumEvenGrandparent(root));
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    TreeNode(int x) {
        val = x;
    }
}
