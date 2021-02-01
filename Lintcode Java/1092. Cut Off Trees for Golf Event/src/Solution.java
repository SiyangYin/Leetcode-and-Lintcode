import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    /**
     * @param forest: a list of integers
     * @return: return a integer
     */
    public int cutOffTree(List<List<Integer>> forest) {
        // write your code here
        int m = forest.size(), n = forest.get(0).size();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((p1, p2) -> Integer.compare(p1[2], p2[2]));
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (forest.get(i).get(j) > 1) {
                    minHeap.offer(new int[]{i, j, forest.get(i).get(j)});
                }
            }
        }
        
        int res = 0;
        int[] cur = {0, 0, 0};
        while (!minHeap.isEmpty()) {
            int[] next = minHeap.poll();
            int step = bfs(cur, next, forest);
            if (step == -1) {
                return -1;
            }
            
            res += step;
            cur = next;
        }
        
        return res;
    }
    
    private int bfs(int[] now, int[] next, List<List<Integer>> forest) {
        if (now[0] == next[0] && now[1] == next[1]) {
            return 0;
        }
        
        int m = forest.size(), n = forest.get(0).size();
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(now);
        visited[now[0]][now[1]] = true;
        int[] d = {1, 0, -1, 0, 1};
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nextX = cur[0] + d[j], nextY = cur[1] + d[j + 1];
                    if (0 <= nextX && nextX < m && 0 <= nextY && nextY < n && !visited[nextX][nextY]) {
                        if (nextX == next[0] && nextY == next[1]) {
                            return step;
                        }
                        
                        if (forest.get(nextX).get(nextY) >= 1) {
                            visited[nextX][nextY] = true;
                            queue.offer(new int[]{nextX, nextY, forest.get(nextX).get(nextY)});
                        }
                    }
                }
            }
        }
        
        return -1;
    }
}
