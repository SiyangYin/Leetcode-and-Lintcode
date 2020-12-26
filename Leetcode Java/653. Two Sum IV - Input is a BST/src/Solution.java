import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean findTarget(TreeNode root, int k) {
        return dfs(root, new HashSet<>(), k);
    }
    
    private boolean dfs(TreeNode root, Set<Integer> set, int k) {
        if (root == null) {
            return false;
        }
        
        if (set.contains(k - root.val)) {
            return true;
        }
        
        set.add(root.val);
        
        return dfs(root.left, set, k) || dfs(root.right, set, k);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}
