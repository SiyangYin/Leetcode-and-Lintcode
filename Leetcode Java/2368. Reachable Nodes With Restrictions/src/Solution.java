import java.util.*;

public class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int[] i : edges) {
            List<Integer> list1 = map.getOrDefault(i[0], new ArrayList<>());
            list1.add(i[1]);
            map.putIfAbsent(i[0], list1);
            List<Integer> list2 = map.getOrDefault(i[1], new ArrayList<>());
            list2.add(i[0]);
            map.putIfAbsent(i[1], list2);
        }
        for (int i : restricted) {
            set.add(i);
        }
        return dfs(map, set, new boolean[n], 0);
    }

    public int dfs(Map<Integer, List<Integer>> map, Set<Integer> set, boolean[] visited, int i) {
        int cnt = 1;
        if (map.containsKey(i)) {
            visited[i] = true;
            List<Integer> list = map.get(i);
            for (int j : list) {
                if (!set.contains(j) && !visited[j]) {
                    cnt += dfs(map, set, visited, j);
                }
            }
        }
        return cnt;
    }
}
