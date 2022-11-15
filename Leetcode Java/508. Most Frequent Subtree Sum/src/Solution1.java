import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1 {
    private Map<Integer, Integer> map = new HashMap<>();
    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        List<Integer> list = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                list.add(entry.getKey());
            }
            else if(entry.getValue() > max) {
                list.clear();
                list.add(entry.getKey());
                max = entry.getValue();
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public int dfs(TreeNode node) {
        if (node.left != null) {
            node.val += dfs(node.left);
        }
        if (node.right != null) {
            node.val += dfs(node.right);
        }
        map.put(node.val, map.getOrDefault(node.val, 0) + 1);
        return node.val;
    }
}

