public class Solution {
    /**
     * @param root:
     * @return: the sum of leafnode
     */
    public int sumLeafNode(TreeNode root) {
        // Write your code here
        int res = 0;
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null && cur.right == null) {
                res += cur.val;
            }
            
            TreeNode left = cur.left;
            if (left == null) {
                cur = cur.right;
            } else {
                while (left.right != null && left.right != cur) {
                    left = left.right;
                }
                
                if (left.left == null && left.right == null) {
                    res += left.val;
                }
                
                if (left.right == null) {
                    left.right = cur;
                    cur = cur.left;
                } else {
                    left.right = null;
                    cur = cur.right;
                }
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        
        System.out.println(new Solution().sumLeafNode(root));
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}