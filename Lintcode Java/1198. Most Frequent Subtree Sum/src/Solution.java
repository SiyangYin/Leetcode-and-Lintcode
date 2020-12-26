import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    /**
     * @param root: the root
     * @return: all the values with the highest frequency in any order
     */
    public int[] findFrequentTreeSum(TreeNode root) {
        // Write your code here
        Map<Integer, Integer> map = new HashMap<>();
        dfs(root, map);
        
        List<Integer> list = new ArrayList<>();
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey(), val = entry.getValue();
            if (list.isEmpty() || val == max) {
                list.add(key);
                max = val;
            } else if (val > max) {
                list.clear();
                list.add(key);
                max = val;
            }
        }
        
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        
        return res;
    }
    
    private int dfs(TreeNode cur, Map<Integer, Integer> map) {
        if (cur == null) {
            return 0;
        }
        
        int sum = cur.val;
        sum += dfs(cur.left, map) + dfs(cur.right, map);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        return sum;
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}