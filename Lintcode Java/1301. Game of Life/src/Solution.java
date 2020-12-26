import java.util.Arrays;

public class Solution {
    /**
     * @param board: the given board
     * @return: nothing
     */
    public void gameOfLife(int[][] board) {
        // Write your code here
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int curState = board[i][j], liveNeighbors = computeLiveNeighbors(board, i, j);
                if (curState == 1 && (liveNeighbors == 2 || liveNeighbors == 3)) {
                    board[i][j] = 3;
                } else if (liveNeighbors == 3) {
                    board[i][j] = 2;
                }
            }
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if ((board[i][j] & 2) == 2) {
                    board[i][j] = 1;
                } else {
                    board[i][j] = 0;
                }
            }
        }
    }
    
    private int computeLiveNeighbors(int[][] board, int x, int y) {
        int count = 0;
        int[][] dir = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        for (int i = 0; i < dir.length; i++) {
            int nextX = x + dir[i][0], nextY = y + dir[i][1];
            if (inBound(board, nextX, nextY)) {
                int curState = board[nextX][nextY] & 1;
                count += curState;
            }
        }
        
        return count;
    }
    
    private boolean inBound(int[][] board, int x, int y) {
        return 0 <= x && x < board.length && 0 <= y && y < board[0].length;
    }
    
    public static void main(String[] args) {
        int[][] board = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}};
        new Solution().gameOfLife(board);
        System.out.println(Arrays.deepToString(board));
    }
}
