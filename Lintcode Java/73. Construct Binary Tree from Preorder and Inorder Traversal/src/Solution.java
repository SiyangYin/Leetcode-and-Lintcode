import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     *@param preorder : A list of integers that preorder traversal of a tree
     *@param inorder : A list of integers that inorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // write your code here
        if (preorder == null || inorder == null || preorder.length * inorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }
    
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        
        int len = preorder.length;
        return build(preorder, 0, len - 1, inorder, 0, len - 1, map);
    }
    
    private TreeNode build(int[] preorder, int l1, int r1, int[] inorder, int l2, int r2, Map<Integer, Integer> map) {
        if (l1 > r1) {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[l1]);
        int idx = map.get(root.val);
        int sizeLeft = idx - l2;
        root.left = build(preorder, l1 + 1, l1 + sizeLeft, inorder, l2, idx - 1, map);
        root.right = build(preorder, l1 + sizeLeft + 1, r1, inorder, idx + 1, r2, map);
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}