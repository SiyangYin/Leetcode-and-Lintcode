import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        return dfs(root, new HashMap<>());
    }
    
    private int dfs(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) {
            return 0;
        }
        return dfs(root.left, map) + dfs(root.right, map) + Math.abs(sum(root.left, map) - sum(root.right, map));
    }
    
    private int sum(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) {
            return 0;
        }
        
        if (map.containsKey(root)) {
            return map.get(root);
        }
        
        int res = root.val;
        res += sum(root.left, map);
        res += sum(root.right, map);
        map.put(root, res);
        
        return res;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(new Solution2().findTilt(root));
    }
}