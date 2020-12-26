import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }
    
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }
    
    private TreeNode build(int[] preorder, int beg1, int end1, int[] inorder, int beg2, int end2, Map<Integer, Integer> map) {
        if (beg1 > end1) {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[beg1]);
        
        int find = map.get(root.val);
        int sizeLeft = find - beg2;
        root.left = build(preorder, beg1 + 1, beg1 + sizeLeft, inorder, beg2, find - 1, map);
        root.right = build(preorder, beg1 + sizeLeft + 1, end1, inorder, find + 1, end2, map);
        return root;
    }
}
