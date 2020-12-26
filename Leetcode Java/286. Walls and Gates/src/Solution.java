import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return;
        }
        
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int x = cur[0], y = cur[1];
                for (int[] next : getNexts(x, y, rooms)) {
                    int nextX = next[0], nextY = next[1];
                    if (rooms[nextX][nextY] > rooms[x][y] + 1) {
                        rooms[nextX][nextY] = rooms[x][y] + 1;
                        queue.offer(new int[]{nextX, nextY});
                    }
                }
            }
        }
    }
    
    private List<int[]> getNexts(int x, int y, int[][] rooms) {
        List<int[]> nexts = new ArrayList<>();
        int[] d = {0, 1, 0, -1, 0};
        for (int i = 0; i < 4; i++) {
            int nextX = x + d[i], nextY = y + d[i + 1];
            if (inBound(nextX, nextY, rooms) && rooms[nextX][nextY] != -1 && rooms[nextX][nextY] != 0) {
                nexts.add(new int[]{nextX, nextY});
            }
        }
        
        return nexts;
    }
    
    private boolean inBound(int x, int y, int[][] rooms) {
        return 0 <= x && x < rooms.length && 0 <= y && y < rooms[0].length;
    }
}
