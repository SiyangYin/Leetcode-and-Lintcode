import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    
    private int maxCount;
    
    /**
     * @param root: a root of integer
     * @return: return a integer list
     */
    public int[] findMode(TreeNode root) {
        // write your code here
        Map<Integer, Integer> map = new HashMap<>();
        dfs(root, map);
        
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxCount) {
                list.add(entry.getKey());
            }
        }
        
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        
        return res;
    }
    
    private void dfs(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) {
            return;
        }
        
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        maxCount = Math.max(maxCount, map.get(root.val));
        
        dfs(root.left, map);
        dfs(root.right, map);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}