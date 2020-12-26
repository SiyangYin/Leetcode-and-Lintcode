import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public int shortestBridge(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0) {
            return 0;
        }
    
        boolean marked = false;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1) {
                    dfs(i, j, A);
                    marked = true;
                    break;
                }
            }
            if (marked) {
                break;
            }
        }
        
        Queue<int[]> beginQueue = new ArrayDeque<>(), endQueue = new ArrayDeque<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1) {
                    beginQueue.offer(new int[]{i, j});
                }
                if (A[i][j] == 2) {
                    endQueue.offer(new int[]{i ,j});
                }
            }
        }
        
        int res = 0;
        while (!beginQueue.isEmpty() && !endQueue.isEmpty()) {
            int beginSize = beginQueue.size(), endSize = endQueue.size();
            for (int i = 0; i < beginSize; i++) {
                int[] cur = beginQueue.poll();
                for (int[] next : getNexts(cur[0], cur[1], A, 1)) {
                    int nextX = next[0], nextY = next[1];
                    if (A[nextX][nextY] == 2) {
                        return res;
                    }
                    A[nextX][nextY] = 1;
                    beginQueue.offer(next);
                }
            }
            
            res++;
            for (int i = 0; i < endSize; i++) {
                int[] cur = endQueue.poll();
                for (int[] next : getNexts(cur[0], cur[1], A, 2)) {
                    int nextX = next[0], nextY = next[1];
                    if (A[nextX][nextY] == 1) {
                        return res;
                    }
                    A[nextX][nextY] = 2;
                    endQueue.offer(next);
                }
            }
            res++;
        }
        
        return -1;
    }
    
    private List<int[]> getNexts(int x, int y, int[][] A, int mark) {
        List<int[]> nexts = new ArrayList<>();
        int[] d = {0, 1, 0, -1, 0};
        for (int i = 0; i < 4; i++) {
            int nextX = x + d[i], nextY = y + d[i + 1];
            if (0 <= nextX && nextX < A.length && 0 <= nextY && nextY < A[0].length && A[nextX][nextY] != mark) {
                nexts.add(new int[]{nextX, nextY});
            }
        }
        
        return nexts;
    }
    
    private void dfs(int x, int y, int[][] A) {
        A[x][y] = 2;
        int[] d = {0, 1, 0, -1, 0};
        for (int i = 0; i < 4; i++) {
            int nextX = x + d[i], nextY = y + d[i + 1];
            if (0 <= nextX && nextX < A.length && 0 <= nextY && nextY < A[0].length && A[nextX][nextY] == 1) {
                dfs(nextX, nextY, A);
            }
        }
    }
}
