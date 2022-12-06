import java.util.*;

public class Solution1 {
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
        dfs(map1, new boolean[n], labels, res, 0);
        return res;
    }

    public int[] dfs(Map<Integer, List<Integer>> map1, boolean[] visited, String labels, int[] res, int i) {
        int[] arr1 = new int[26];
        if (map1.containsKey(i)) {
            visited[i] = true;
            List<Integer> list = map1.get(i);
            for (int j : list) {
                if (!visited[j]) {
                    int[] arr2 = dfs(map1, visited, labels, res, j);
                    for (int k = 0; k < 26; k++) {
                        arr1[k] += arr2[k];
                    }
                }
            }
        }
        res[i] = ++arr1[labels.charAt(i) - 'a'];
        return arr1;
    }

    public static void main(String[] args) {
        int[] res = new Solution1().countSubTrees(4, new int[][]{{0, 2}, {0, 3}, {1, 2}}, "aeed");
        Arrays.stream(res).forEach(i -> System.out.print(i + ","));
    }
}
