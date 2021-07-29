import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        Map<String, List<TreeNode>> map = new HashMap<>();
        dfs(root, map);
        for (Map.Entry<String, List<TreeNode>> entry : map.entrySet()) {
            if (entry.getValue().size() > 1) {
                res.add(entry.getValue().get(1));
            }
        }
        
        return res;
    }
    
    private String dfs(TreeNode root, Map<String, List<TreeNode>> map) {
        if (root == null) {
            return "#";
        }
        
        String s = String.valueOf(root.val) + ' ' + dfs(root.left, map) + ' ' + dfs(root.right, map);
        map.putIfAbsent(s, new ArrayList<>());
        map.get(s).add(root);
        return s;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.left.left = new TreeNode(4);
        root.right.right = new TreeNode(4);
        List<TreeNode> list = new Solution().findDuplicateSubtrees(root);
        System.out.println(list);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}