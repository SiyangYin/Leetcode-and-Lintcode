import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    /**
     * @param board: board
     * @return: snakesAndLadders
     */
    public int snakesAndLadders(int[][] board) {
        // write your code here
        int n = board.length;
        int start = 0, end = n * n - 1;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        boolean[] visited = new boolean[n * n];
        visited[0] = true;
        
        int res = 0;
        while (!queue.isEmpty()) {
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                for (int j = 1; j <= 6 && cur + j < n * n; j++) {
                    int next = cur + j;
                    int[] trans = transfer(next, n);
                    if (board[trans[0]][trans[1]] != -1) {
                        next = board[trans[0]][trans[1]] - 1;
                    }
                    
                    if (next == end) {
                        return res;
                    }
                    
                    if (!visited[next]) {
                        queue.offer(next);
                        visited[next] = true;
                    }
                }
            }
        }
        
        return -1;
    }
    
    private int[] transfer(int idx, int n) {
        int x = n - 1 - idx / n;
        int y = (n - 1 - x) % 2 == 0 ? idx % n : n - 1 - idx % n;
        return new int[]{x, y};
    }
    
    public static void main(String[] args) {
        /*int[][] board = {
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 35, -1, -1, 13, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 15, -1, -1, -1, -1}};
        */
        int[][] board = {
                {-1, 1, -1},
                {-1, -1, -1},
                {-1, 2, 9}};
        
        System.out.println(new Solution().snakesAndLadders(board));
    }
}
