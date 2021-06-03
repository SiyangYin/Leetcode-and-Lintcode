import java.util.*;

public class Solution {
    public int cutOffTree(List<List<Integer>> forest) {
        int m = forest.size(), n = forest.get(0).size();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((x, y) -> Integer.compare(x[0], y[0]));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int h = forest.get(i).get(j);
                if (h > 1) {
                    minHeap.offer(new int[]{h, i, j});
                }
            }
        }
        
        int res = 0;
        int[] cur = {forest.get(0).get(0), 0, 0};
        while (!minHeap.isEmpty()) {
            int[] next = minHeap.poll();
            int steps = bfs(cur, next, forest);
            if (steps == -1) {
                return -1;
            }
            
            res += steps;
            cur = next;
        }
        
        return res;
    }
    
    private int bfs(int[] cur, int[] next, List<List<Integer>> forest) {
        if (Arrays.equals(cur, next)) {
            return 0;
        }
        
        int m = forest.size(), n = forest.get(0).size();
        int[] d = {1, 0, -1, 0, 1};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(cur);
        boolean[][] vis = new boolean[m][n];
        vis[cur[1]][cur[2]] = true;
        
        int res = 0;
        while (!queue.isEmpty()) {
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                cur = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nextX = cur[1] + d[j], nextY = cur[2] + d[j + 1];
                    if (0 <= nextX && nextX < m && 0 <= nextY && nextY < n) {
                        if (nextX == next[1] && nextY == next[2]) {
                            return res;
                        }
    
                        int h = forest.get(nextX).get(nextY);
                        if (h >= 1 && !vis[nextX][nextY]) {
                            queue.offer(new int[]{h, nextX, nextY});
                            vis[nextX][nextY] = true;
                        }
                    }
                }
            }
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        List<List<Integer>> l = new ArrayList<>(){{
            add(Arrays.asList(1, 2, 3));
            add(Arrays.asList(0, 0, 0));
            add(Arrays.asList(7, 6, 5));
        }};
        System.out.println(new Solution().cutOffTree(l));
    }
}
