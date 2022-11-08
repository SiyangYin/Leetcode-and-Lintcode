import java.util.HashMap;
import java.util.Map;

public class Solution1 {
    private Map<TreeNode, Boolean> map1 = new HashMap<>();
    private Map<TreeNode, Boolean> map2 = new HashMap<>();
    private Map<TreeNode, Boolean> map3 = new HashMap<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        boolean left = isAncestor(root.left, p, q);
        boolean right = isAncestor(root.right, p, q);
        while (left || right) {
            if (left) {
                root = root.left;
            }
            else if (right) {
                root = root.right;
            }
            left = isAncestor(root.left, p, q);
            right = isAncestor(root.right, p, q);
        }
        return root;
    }

    public boolean isAncestor(TreeNode node, TreeNode p, TreeNode q) {
        if (map3.containsKey(node)) {
            return map3.get(node);
        }
        map3.put(node, find(node, p, map1) && find(node, q, map2));
        return map3.get(node);
    }

    public boolean find(TreeNode node, TreeNode target, Map<TreeNode, Boolean> map) {
        if (map.containsKey(node)){
            return map.get(node);
        }
        if (node == null) {
            map.put(node, false);
            return false;
        }
        map.put(node, node == target || find(node.left, target, map) || find(node.right, target, map));
        return map.get(node);
    }
}

