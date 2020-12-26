public class Solution {
    
    private int res;
    
    /**
     * @param root: the root
     * @return: the largest subtree's size which is a Binary Search Tree
     */
    public int largestBSTSubtree(TreeNode root) {
        // Write your code here
        if (root == null) {
            return 0;
        }
        
        dfs(root);
        
        return res;
    }
    
    // 返回一个数组，第0个数是以cur为根的子树节点个数，如果不是BST则返回-1，第1个数是该子树的最小值，第2个数是该子树的最大值；
    // 如果是空树则返回null
    private int[] dfs(TreeNode cur) {
        if (cur == null) {
            return null;
        }
        
        int[] left = dfs(cur.left), right = dfs(cur.right);
        if (left == null && right == null) {
            res = Math.max(res, 1);
            return new int[]{1, cur.val, cur.val};
        }
        
        if (left == null) {
            if (right[0] == -1 || cur.val >= right[1]) {
                return new int[]{-1, 0, 0};
            } else {
                res = Math.max(res, 1 + right[0]);
                return new int[]{1 + right[0], cur.val, right[2]};
            }
        }
        
        if (right == null) {
            if (left[0] == -1 || cur.val <= left[2]) {
                return new int[]{-1, 0, 0};
            } else {
                res = Math.max(res, 1 + left[0]);
                return new int[]{1 + left[0], left[1], cur.val};
            }
        }
        
        if (left[0] == -1 || right[0] == -1 || cur.val <= left[2] || cur.val >= right[1]) {
            return new int[]{-1, 0, 0};
        } else {
            res = Math.max(res, 1 + left[0] + right[0]);
            return new int[]{1 + left[0] + right[0], left[1], right[2]};
        }
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(8);
        root.right = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new Solution().largestBSTSubtree(root));
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}