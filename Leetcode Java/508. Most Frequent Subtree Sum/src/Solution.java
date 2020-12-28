import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        dfs(root, map);
        List<Integer> list = new ArrayList<>();
    
        int maxFreq = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxFreq) {
                maxFreq = entry.getValue();
                list.clear();
                list.add(entry.getKey());
            } else if (entry.getValue() == maxFreq) {
                list.add(entry.getKey());
            }
        }
        
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        
        return res;
    }
    
    private int dfs(TreeNode cur, Map<Integer, Integer> map) {
        if (cur == null) {
            return 0;
        }
    
        int left = dfs(cur.left, map), right = dfs(cur.right, map), s = left + right + cur.val;
        map.put(s, map.getOrDefault(s, 0) + 1);
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