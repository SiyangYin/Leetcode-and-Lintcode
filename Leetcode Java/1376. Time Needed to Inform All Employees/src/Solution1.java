import java.util.*;

public class Solution1 {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < manager.length; i++) {
            List<Integer> list = map.getOrDefault(manager[i], new ArrayList<>());
            list.add(i);
            map.putIfAbsent(manager[i], list);
        }
        return dfs(map, informTime, headID);
    }

    public int dfs(Map<Integer, List<Integer>> map, int[] informTime, int i) {
        int max = 0;
        if (map.containsKey(i)) {
            List<Integer> list = map.get(i);
            for (int j : list) {
                max = Math.max(max, dfs(map, informTime, j));
            }
        }
        return max + informTime[i];
    }
    
    public static void main(String[] args) {
        int n = 7, headid = 6;
        int[] manager = {1, 2, 3, 4, 5, 6, -1}, infortime = {0, 6, 5, 4, 3, 2, 1};
        System.out.println(new Solution1().numOfMinutes(n, headid, manager, infortime));
    }
}
