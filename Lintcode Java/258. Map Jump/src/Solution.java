import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    
    class Pair {
        int x, y, tar;
        
        public Pair(int x, int y, int tar) {
            this.x = x;
            this.y = y;
            this.tar = tar;
        }
    }
    
    /**
     * @param arr: the map
     * @return: the smallest target that satisfies from the upper left corner (0, 0) to the lower right corner (n-1, n-1)
     */
    public int mapJump(int[][] arr) {
        // Write your code here.
        int m = arr.length, n = arr[0].length;
        int[][] minTar = new int[m][n];
        for (int[] row : minTar) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        boolean[][] visited = new boolean[m][n];
        Pair start = new Pair(0, 0, 0);
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((p1, p2) -> Integer.compare(p1.tar, p2.tar));
        minHeap.offer(start);
        while (!minHeap.isEmpty()) {
            Pair cur = minHeap.poll();
            int x = cur.x, y = cur.y;
            if (x == m - 1 && y == n - 1) {
                return minTar[m - 1][n - 1];
            }
            
            visited[x][y] = true;
            for (Pair next : calNexts(cur, minTar, arr, visited)) {
                minHeap.offer(next);
            }
        }
        
        return -1;
    }
    
    private List<Pair> calNexts(Pair cur, int[][] minTar, int[][] arr, boolean[][] visited) {
        List<Pair> nexts = new ArrayList<>();
        int x = cur.x, y = cur.y;
        int[] d = {1, 0, -1, 0, 1};
        for (int i = 0; i < 4; i++) {
            int nextX = x + d[i], nextY = y + d[i + 1];
            if (!inBound(nextX, nextY, arr) || visited[nextX][nextY]) {
                continue;
            }
            
            int nextTar = Math.max(cur.tar, Math.abs(arr[nextX][nextY] - arr[x][y]));
            if (minTar[nextX][nextY] > nextTar) {
                Pair next = new Pair(nextX, nextY, Math.max(cur.tar, nextTar));
                nexts.add(next);
                minTar[nextX][nextY] = nextTar;
            }
        }
        
        return nexts;
    }
    
    private boolean inBound(int x, int y, int[][] arr) {
        return 0 <= x && x < arr.length && 0 <= y && y < arr[0].length;
    }
    
    public static void main(String[] args) {
        int[][] arr = {{1, 5}, {6, 2}};
        System.out.println(new Solution().mapJump(arr));
    }
}
