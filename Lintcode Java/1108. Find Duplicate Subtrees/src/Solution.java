import java.util.*;

public class Solution {
    /**
     * @paramn n: An integer
     * @return: A list of root
     */
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        // write your code here
        List<TreeNode> res = new ArrayList<>();
        dfs(root, new HashMap<>(), res);
        return res;
    }
    
    private String dfs(TreeNode cur, Map<String, Integer> map, List<TreeNode> res) {
        if (cur == null) {
            return "#";
        }
     
        String s = String.valueOf(cur.val) + ' ' + dfs(cur.left, map,res) + ' ' + dfs(cur.right, map, res);
        if (Objects.equals(map.put(s, map.getOrDefault(s, 0) + 1), 1)) {
            res.add(cur);
        }
        
        return s;
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}