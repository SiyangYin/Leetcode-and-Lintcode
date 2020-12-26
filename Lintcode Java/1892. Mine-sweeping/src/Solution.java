import java.util.*;

public class Solution {
    /**
     * @param Mine_map: an array represents the map.
     * @param Start:    the start position.
     * @return: return an array including all reachable positions.
     */
    public List<List<Integer>> Mine_sweeping(int[][] Mine_map, int[] Start) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        
        int x = Start[0], y = Start[1];
        if (Mine_map[x][y] == 0) {
            res.add(Arrays.asList(x, y));
            return res;
        }
        
        int m = Mine_map.length, n = Mine_map[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        visited[x][y] = true;
        queue.offer(Start);
        res.add(Arrays.asList(x, y));
        
        int[] d = {1, 0, -1, 0, 1};
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = cur[0] + d[i], nextY = cur[1] + d[i + 1];
                if (0 <= nextX && nextX < m && 0 <= nextY && nextY < n && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    res.add(Arrays.asList(nextX, nextY));
                    if (Mine_map[nextX][nextY] == 1) {
                        queue.offer(new int[]{nextX, nextY});
                    }
                }
            }
        }
        
        return res;
    }
}
