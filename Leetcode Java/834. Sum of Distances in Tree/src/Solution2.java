import java.util.*;

public class Solution2 {
    private Map<Integer, List<Integer>> map = new HashMap<>();
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        for (int[] i : edges) {
            List<Integer> list1 = map.getOrDefault(i[0], new ArrayList<>());
            list1.add(i[1]);
            map.putIfAbsent(i[0], list1);
            List<Integer> list2 = map.getOrDefault(i[1], new ArrayList<>());
            list2.add(i[0]);
            map.putIfAbsent(i[1], list2);
        }
        int[] res = new int[n];
        for (int i : map.keySet()) {
            boolean[] visited = new boolean[n];
            visited[i] = true;
            res[i] = 1;
            dfs(i, i, visited, res, 0);
        }
        return res;
    }

    public void dfs(int i, int j, boolean[] visited, int[] res, int depth) {
        List<Integer> list = map.get(j);
        res[i] += (map.get(j).size() - 1) * (depth + 1);
        for (int k : list) {
            if (!visited[k]) {
                visited[k] = true;
                dfs(i, k, visited, res, depth + 1);
            }
        }
    }
    
    public static void main(String[] args) {
        int n = 6;
        int[][] e = {{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}};
        System.out.println(Arrays.toString(new Solution2().sumOfDistancesInTree(n, e)));
    }
}
