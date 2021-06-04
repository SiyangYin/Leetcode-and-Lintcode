import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int[][] highestPeak(int[][] A) {
        int m = A.length, n = A[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 1) {
                    A[i][j] = 0;
                    queue.offer(new int[]{i, j});
                } else {
                    A[i][j] = -1;
                }
            }
        }
        
        int[] d = {1, 0, -1, 0, 1};
        
        for (int h = 1; !queue.isEmpty(); h++) {
            for (int i = queue.size() - 1; i >= 0; i--) {
                int[] cur = queue.poll();
                int x = cur[0], y = cur[1];
                for (int k = 0; k < 4; k++) {
                    int nextX = x + d[k], nextY = y + d[k + 1];
                    if (0 <= nextX && nextX < m && 0 <= nextY && nextY < n && A[nextX][nextY] == -1) {
                        A[nextX][nextY] = h;
                        queue.offer(new int[]{nextX, nextY});
                    }
                }
            }
        }
        
        return A;
    }
    
    public static void main(String[] args) {
        int[][] a = {{0, 1}, {0, 0}};
        System.out.println(Arrays.deepToString(new Solution().highestPeak(a)));
    }
}
