import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    private double res = 0;
    public double frogPosition(int n, int[][] edges, int t, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] i : edges) {
            List<Integer> list1 = map.getOrDefault(i[0], new ArrayList<>());
            list1.add(i[1]);
            map.putIfAbsent(i[0], list1);
            List<Integer> list2 = map.getOrDefault(i[1], new ArrayList<>());
            list2.add(i[0]);
            map.putIfAbsent(i[1], list2);
        }
        dfs(map, new boolean[n + 1], 1, t, target, 1);
        return res;
    }

    public void dfs(Map<Integer, List<Integer>> map, boolean[] visited, int i, int t, int target, double prob) {
        if (map.containsKey(i)) {
            visited[i] = true;
            List<Integer> list = map.get(i);
            if (i == 1) {
                prob /= list.size();
                for (int j : list) {
                    if (!visited[j]) {
                        if (t == 1 && j == target) {
                            res = prob;
                            return;
                        }
                        else if (t > 0) {
                            dfs(map, visited, j, t - 1, target, prob);
                        }
                    }
                }
            }
            else {
                if (list.size() == 1) {
                    if (i == target) {
                        res = prob;
                        return;
                    }
                }
                else {
                    prob /= list.size() - 1;
                    for (int j : list) {
                        if (!visited[j]) {
                            if (t == 1 && j == target) {
                                res = prob;
                                return;
                            }
                            else if (t > 0) {
                                dfs(map, visited, j, t - 1, target, prob);
                            }
                        }
                    }
                }
            }
        }
        else if (i == target){
            res = prob;
            return;
        }
    }

    public static void main(String[] args) {
        int n = 7, t = 2, target = 4;
        int[][] edges = new int[][]{{1,2},{1,3},{1,7},{2,4},{2,6},{3,5}};
        System.out.println(new Solution().frogPosition(n, edges, 2, 4));
        System.out.println(new Solution().frogPosition(n, edges, 1, 7));
    }
}