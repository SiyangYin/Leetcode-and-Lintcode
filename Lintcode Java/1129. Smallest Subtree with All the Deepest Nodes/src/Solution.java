public class Solution {
    
    class Pair {
        TreeNode node;
        int depth;
    
        public Pair(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
    
    /**
     * @param root: a binary tree.
     * @return: return the minimun subtree contains all the key nodes.
     */
    public TreeNode subtreeWithAllKeyNodes(TreeNode root) {
        // write your code here.
        return dfs(root, 0).node;
    }
    
    private Pair dfs(TreeNode cur, int depth) {
        if (cur == null) {
            return null;
        }
    
        Pair left = dfs(cur.left, depth + 1), right = dfs(cur.right, depth + 1);
        if (left == null && right == null) {
            return new Pair(cur, depth);
        } else if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            if (left.depth > right.depth) {
                return left;
            } else if (left.depth < right.depth) {
                return right;
            } else {
                left.node = cur;
                return left;
            }
        }
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(1);
        TreeNode node = new Solution().subtreeWithAllKeyNodes(root);
        System.out.println(node);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}