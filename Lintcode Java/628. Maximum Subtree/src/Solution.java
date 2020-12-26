import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * @param root: the root of binary tree
     * @return: the maximum weight node
     */
    public TreeNode findSubtree(TreeNode root) {
        // write your code here
        if (root == null) {
            return root;
        }
        
        Map<TreeNode, Integer> map = new HashMap<>();
        map.put(null, 0);
        return find(root, map);
    }
    
    private TreeNode find(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) {
            return null;
        }
        
        TreeNode left = find(root.left, map), right = find(root.right, map);
        int sum = sum(root, map), lSum = map.get(left), rSum = map.get(right);
        if (left == null && right == null) {
            return root;
        } else if (right == null) {
            return sum >= lSum ? root : left;
        } else if (left == null) {
            return sum >= rSum ? root : right;
        } else {
            if (sum >= Math.max(lSum, rSum)) {
                return root;
            } else {
                return lSum >= rSum ? left : right;
            }
        }
    }
    
    private int sum(TreeNode root, Map<TreeNode, Integer> map) {
        if (map.containsKey(root)) {
            return map.get(root);
        }
        
        map.put(root, sum(root.left, map) + sum(root.right, map) + root.val);
        return map.get(root);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}