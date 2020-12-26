import java.util.*;

public class Solution {
    public int deleteTreeNodes(int nodes, int[] parent, int[] value) {
        Map<Integer, List<Integer>> tree = buildTree(nodes, parent);
        int[] numOfNodes = new int[nodes];
        Arrays.fill(numOfNodes, 1);
        dfs(0, tree, value, numOfNodes);
        
        return nodes - dfs2(0, tree, value, numOfNodes);
    }
    
    private int dfs2(int cur, Map<Integer, List<Integer>> tree, int[] value, int[] numOfNodes) {
        if (value[cur] == 0) {
            return numOfNodes[cur];
        }
        
        int res = 0;
        if (tree.containsKey(cur)) {
            for (int next : tree.get(cur)) {
                res += dfs2(next, tree, value, numOfNodes);
            }
        }
        
        return res;
    }
    
    private void dfs(int cur, Map<Integer, List<Integer>> tree, int[] value, int[] numOfNodes) {
        if (!tree.containsKey(cur)) {
            return;
        }
        
        for (int next : tree.get(cur)) {
            dfs(next, tree, value, numOfNodes);
            value[cur] += value[next];
            numOfNodes[cur] += numOfNodes[next];
        }
    }
    
    private Map<Integer, List<Integer>> buildTree(int nodes, int[] parent) {
        Map<Integer, List<Integer>> tree = new HashMap<>();
        for (int i = 0; i < nodes; i++) {
            tree.putIfAbsent(parent[i], new ArrayList<>());
            tree.get(parent[i]).add(i);
        }
        
        return tree;
    }
    
    public static void main(String[] args) {
        int nodes = 7;
        int[] par = {-1, 0, 0, 1, 2, 2, 2}, val = {1, -2, 4, 0, -2, -1, -1};
        System.out.println(new Solution().deleteTreeNodes(nodes, par, val));
    }
}
