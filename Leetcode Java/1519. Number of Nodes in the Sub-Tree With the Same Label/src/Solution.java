import java.util.*;

public class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        Map<Integer, List<Integer>> map1 = new HashMap<>();
        for (int[] i : edges) {
            List<Integer> list1 = map1.getOrDefault(i[0], new ArrayList<>());
            list1.add(i[1]);
            map1.putIfAbsent(i[0], list1);
            List<Integer> list2 = map1.getOrDefault(i[1], new ArrayList<>());
            list2.add(i[0]);
            map1.putIfAbsent(i[1], list2);
        }
        int[] res = new int[n];
        dfs(map1, new HashSet<>(), new boolean[n], labels, res, 0);
        return res;
    }

    public Map<Character, Integer> dfs(Map<Integer, List<Integer>> map1, Set<Character> set, boolean[] visited, String labels, int[] res, int i) {
        Map<Character, Integer> map2 = new HashMap<>();
        if (map1.containsKey(i)) {
            visited[i] = true;
            set.add(labels.charAt(i));
            List<Integer> list = map1.get(i);
            for (int j : list) {
                if (!visited[j]) {
                    Map<Character, Integer> map3 = dfs(map1, set, visited, labels, res, j);
                    for (char c : set) {
                        map2.put(c, map2.getOrDefault(c, 0) + map3.getOrDefault(c, 0));
                    }
                }
            }
        }
        map2.put(labels.charAt(i), map2.getOrDefault(labels.charAt(i), 0) + 1);
        res[i] = map2.get(labels.charAt(i));
        return map2;
    }

    public static void main(String[] args) {
        int[] res = new Solution().countSubTrees(4, new int[][]{{0, 2}, {0, 3}, {1, 2}}, "aeed");
        Arrays.stream(res).forEach(i -> System.out.print(i + ","));
    }
}
