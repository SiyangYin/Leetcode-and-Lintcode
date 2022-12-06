import java.util.*;

public class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] i : edges) {
            List<Integer> list1 = map.getOrDefault(i[0], new ArrayList<>());
            list1.add(i[1]);
            map.putIfAbsent(i[0], list1);
            List<Integer> list2 = map.getOrDefault(i[1], new ArrayList<>());
            list2.add(i[0]);
            map.putIfAbsent(i[1], list2);
        }
        return dfs(map, hasApple, new boolean[n], 0);
    }

    public int dfs(Map<Integer, List<Integer>> map, List<Boolean> hasApple, boolean[] visited, int i) {
        int t = 0;
        if (map.containsKey(i)) {
            visited[i] = true;
            List<Integer> list = map.get(i);
            for (int j : list) {
                if (!visited[j]) {
                    if (!map.containsKey(j) && hasApple.get(j)) {
                        t += 2;
                    }
                    else {
                        int val = dfs(map, hasApple, visited, j);
                        if (val > 0) {
                            t += val + 2;
                        }
                        else if (hasApple.get(j)) {
                            t += 2;
                        }
                    }
                }
            }
        }
        return t;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().minTime(4, new int[][]{{0, 2}, {0, 3}, {1, 2}}, Arrays.asList(false,true,false,false)));
    }
}
