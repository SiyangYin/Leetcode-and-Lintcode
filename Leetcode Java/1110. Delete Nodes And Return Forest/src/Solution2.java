import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution2 {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> set = new HashSet<>();
        for (int i : to_delete) {
            set.add(i);
        }
        
        List<TreeNode> res = new ArrayList<>();
        dfs(root, null, set, res);
        return res;
    }
    
    public TreeNode dfs(TreeNode node, TreeNode parent, Set<Integer> set, List<TreeNode> res) {
        if (node == null) {
            return null;
        }
        
        node.left = dfs(node.left, node, set, res);
        node.right = dfs(node.right, node, set, res);
        
        if (set.contains(node.val)) {
            return null;
        } else if (parent == null || set.contains(parent.val)) {
            res.add(node);
        }
        
        return node;
    }
}
