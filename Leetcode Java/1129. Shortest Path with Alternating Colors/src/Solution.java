import java.util.*;

public class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        Map<Integer, List<Integer>>[] maps = (Map<Integer, List<Integer>>[]) (new HashMap[2]);
        maps[0] = new HashMap<>();
        maps[1] = new HashMap<>();
        
        for (int[] red_edge : red_edges) {
            int from = red_edge[0], to = red_edge[1];
            maps[0].putIfAbsent(from, new ArrayList<>());
            maps[0].get(from).add(to);
        }
        for (int[] blue_edge : blue_edges) {
            int from = blue_edge[0], to = blue_edge[1];
            maps[1].putIfAbsent(from, new ArrayList<>());
            maps[1].get(from).add(to);
        }
        
        int[] res = new int[n];
        Arrays.fill(res, -1);
        
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, -1});
        res[0] = 0;
        boolean[][] visited = new boolean[n][2];
        
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int pos = cur[0], color = cur[1];
                for (int j = 0; j < 2; j++) {
                    if (j == color) {
                        continue;
                    }
                    
                    if (maps[j].containsKey(pos)) {
                        for (int next : maps[j].get(pos)) {
                            if (!visited[next][j]) {
                                queue.offer(new int[]{next, j});
                                visited[next][j] = true;
                                if (res[next] == -1) {
                                    res[next] = step;
                                }
                            }
                        }
                    }
                }
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[][] r = {{0, 1}, {1, 1}}, b = {{1, 1}, {1, 2}};
        System.out.println(Arrays.toString(new Solution().shortestAlternatingPaths(3, r, b)));
    }
}
