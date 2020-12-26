import java.util.HashMap;
import java.util.Map;

public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0) {
            return null;
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
    }
    
    private TreeNode build(int[] inorder, int beg1, int end1, int[] postorder, int beg2, int end2, Map<Integer, Integer> map) {
        if (beg1 > end1) {
            return null;
        }
        
        TreeNode root = new TreeNode(postorder[end2]);
        int find = map.get(root.val);
        int sizeLeft = find - beg1;
        root.left = build(inorder, beg1, find - 1, postorder, beg2, beg2 + sizeLeft - 1, map);
        root.right = build(inorder, find + 1, end1, postorder, beg2 + sizeLeft, end2 - 1, map);
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
