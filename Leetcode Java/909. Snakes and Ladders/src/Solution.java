import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        if (n == 1) {
            return 0;
        }
        
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        
        boolean[] visited = new boolean[n * n];
        visited[0] = true;
        
        int res = 0;
        while (!queue.isEmpty()) {
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                for (int j = 1; j <= 6; j++) {
                    if (cur + j == n * n - 1) {
                        return res;
                    }
                    
                    if (cur + j >= n * n) {
                        break;
                    }
                    
                    int[] nextPos = transform(cur + j, n);
                    int x = nextPos[0], y = nextPos[1];
                    if (board[x][y] != -1) {
                        if (board[x][y] == n * n) {
                            return res;
                        }
                        
                        if (!visited[board[x][y] - 1]) {
                            visited[board[x][y] - 1] = true;
                            queue.offer(board[x][y] - 1);
                        }
                        
                        continue;
                    }
                    
                    if (!visited[cur + j]) {
                        visited[cur + j] = true;
                        queue.offer(cur + j);
                    }
                }
            }
        }
        
        return -1;
    }
    
    private int[] transform(int x, int n) {
        return new int[]{n - 1 - x / n, x / n % 2 == 0 ? x % n : n - 1 - x % n};
    }
    
    public static void main(String[] args) {
        int[][] mat = {
                {1, 1, -1},
                {1, 1, 1},
                {-1, 1, 1}};
        System.out.println(new Solution().snakesAndLadders(mat));
    }
}
