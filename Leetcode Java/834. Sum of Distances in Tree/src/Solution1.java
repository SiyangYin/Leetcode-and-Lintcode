import java.util.*;

public class Solution1 {
    private Map<Integer, List<Integer>> map = new HashMap<>();
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        int[][] mat = new int[n][n];
        for (int[] i : edges) {
            mat[i[0]][i[1]] = 1;
            mat[i[1]][i[0]] = 1;
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
            dfs(mat, i, i, visited, res);
        }
        return res;
    }

    public void dfs(int[][] mat, int i, int j, boolean[] visited, int[] res) {
         List<Integer> list = map.get(j);
        for (int k : list) {
            if (!visited[k]) {
                visited[k] = true;
                 mat[i][k] = mat[i][j] + mat[j][k];
                 res[i] += mat[i][k];
                dfs(mat, i, k, visited, res);
            }
        }
    }
    
    public static void main(String[] args) {
        int n = 6;
        int[][] e = {{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}};
        System.out.println(Arrays.toString(new Solution1().sumOfDistancesInTree(n, e)));
    }
}
