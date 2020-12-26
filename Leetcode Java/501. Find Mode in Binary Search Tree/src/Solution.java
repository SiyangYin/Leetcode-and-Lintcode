import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        dfs(root, map);
        int maxCount = 0;
        List<Integer> list = new ArrayList<>();
    
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                list.clear();
                list.add(entry.getKey());
            } else if (entry.getValue() == maxCount) {
                list.add(entry.getKey());
            }
        }
        
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        
        return res;
    }
    
    private void dfs(TreeNode cur, Map<Integer, Integer> map) {
        if (cur == null) {
            return;
        }
        
        map.put(cur.val, map.getOrDefault(cur.val, 0) + 1);
        dfs(cur.left, map);
        dfs(cur.right, map);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}