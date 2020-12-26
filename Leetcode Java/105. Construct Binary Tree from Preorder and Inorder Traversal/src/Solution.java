public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }
        
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode build(int[] preorder, int beg1, int end1, int[] inorder, int beg2, int end2) {
        if (beg1 > end1 || beg2 > end2) {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[beg1]);
        int find = -1;
        for (int i = beg2; i <= end2; i++) {
            if (inorder[i] == root.val) {
                find = i;
                break;
            }
        }
        int sizeLeft = find - beg2;
        root.left = build(preorder, beg1 + 1, beg1 + sizeLeft, inorder, beg2, find - 1);
        root.right = build(preorder, beg1 + sizeLeft + 1, end1, inorder, find + 1, end2);
        return root;
    }
    
    public static void main(String[] args) {
        int[] pre = {1, 2, 3};
        int[] in = {3, 2, 1};
        TreeNode root = new Solution().buildTree(pre, in);
        System.out.println(root);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}
