public class Solution {
    
    class Pair {
        int depth;
        TreeNode node;
        
        public Pair(int depth, TreeNode node) {
            this.depth = depth;
            this.node = node;
        }
    }
    
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        return dfs(root, 0).node;
    }
    
    private Pair dfs(TreeNode cur, int depth) {
        if (cur == null) {
            return null;
        }
        
        Pair left = dfs(cur.left, depth + 1), right = dfs(cur.right, depth + 1);
        if (left == null && right == null) {
            return new Pair(depth, cur);
        }
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        if (left.depth == right.depth) {
            left.node = cur;
            return left;
        }
        
        if (left.depth > right.depth) {
            return left;
        } else {
            return right;
        }
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        
        System.out.println(new Solution().lcaDeepestLeaves(root).val);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}