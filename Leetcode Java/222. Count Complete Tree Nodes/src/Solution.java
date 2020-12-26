public class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int[] heights = height(root);
        int hLeft = heights[0] - 1;
        int hRight = heights[1] - 1;
        if (hLeft == hRight) {
            return (1 << (hLeft + 1)) - 1;
        } else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }
    
    private int[] height(TreeNode root) {
        int hL = 0, hR = 0;
        TreeNode cur = root;
        while (cur != null) {
            hL++;
            cur = cur.left;
        }
        cur = root;
        while (cur != null) {
            hR++;
            cur = cur.right;
        }
        
        return new int[]{hL, hR};
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
        
        System.out.println(new Solution().countNodes(root));
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}