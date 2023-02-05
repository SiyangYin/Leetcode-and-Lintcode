import java.util.*;

public class Solution4 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int[] i : prerequisites) {
            set1.add(i[0]);
            set1.add(i[1]);
            List<Integer> list = map.getOrDefault(i[0], new ArrayList<>());
            list.add(i[1]);
            map.putIfAbsent(i[0], list);
        }
        boolean[] visited = new boolean[numCourses];
        for (int i : set1) {
            if (!set2.contains(i)) {
                set2.add(i);
                visited[i] = true;
                if (!dfs(i, visited, map, set2)) {
                    return false;
                }
                visited[i] = false;
            }
            if (set2.size() == set1.size()) {
                return true;
            }
        }
        return true;
    }

    public boolean dfs(int i, boolean[] visited, Map<Integer, List<Integer>> map, Set<Integer> set) {
        if (map.containsKey(i)) {
            List<Integer> list = map.get(i);
            for (int j : list) {
                if (visited[j]) {
                    return false;
                }
                else if (!set.contains(j)) {
                    set.add(j);
                    visited[j] = true;
                    if (!dfs(j, visited, map, set)) {
                        return false;
                    }
                    visited[j] = false;
                }
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        int num = 2;
        int[][] prerequisites = {{1, 0}, {0, 1}};
        System.out.println(new Solution4().canFinish(num, prerequisites));
    }
}
