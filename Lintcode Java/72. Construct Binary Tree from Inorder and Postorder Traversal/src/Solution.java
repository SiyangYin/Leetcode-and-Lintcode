import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * @param inorder: A list of integers that inorder traversal of a tree
     * @param postorder: A list of integers that postorder traversal of a tree
     * @return: Root of a tree
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // write your code here
        if (inorder == null || postorder == null || inorder.length * postorder.length == 0 || inorder.length != postorder.length) {
            return null;
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        
        int len = inorder.length;
        return build(inorder, 0, len - 1, postorder, 0, len - 1, map);
    }
    
    private TreeNode build(int[] inorder, int l1, int r1, int[] postorder, int l2, int r2, Map<Integer, Integer> map) {
        if (l1 > r1) {
            return null;
        }
        
        int idx = map.get(postorder[r2]);
        int sizeLeft = idx - l1;
        TreeNode root = new TreeNode(postorder[r2]);
        root.left = build(inorder, l1, idx - 1, postorder, l2, l2 + sizeLeft - 1, map);
        root.right = build(inorder, idx + 1, r1, postorder, l2 + sizeLeft, r2 - 1, map);
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