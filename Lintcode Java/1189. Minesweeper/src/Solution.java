import java.util.Arrays;

public class Solution {
    /**
     * @param board: a board
     * @param click: the position
     * @return: the new board
     */
    public char[][] updateBoard(char[][] board, int[] click) {
        // Write your code here
        int x = click[0], y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        }
        
        if (board[x][y] == 'B' || Character.isDigit(board[x][y])) {
            return board;
        }
        
        int count = count(board, x, y);
        if (count != 0) {
            board[x][y] = (char) ('0' + count);
            return board;
        }
        
        dfs(x, y, board);
        return board;
    }
    
    private void dfs(int x, int y, char[][] board) {
        int count = count(board, x, y);
        if (count > 0) {
            board[x][y] = (char) ('0' + count);
            return;
        }
        
        board[x][y] = 'B';
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                
                int nextX = x + i, nextY = y + j;
                if (inBound(nextX, nextY, board) && board[nextX][nextY] == 'E') {
                    dfs(nextX, nextY, board);
                }
            }
        }
    }
    
    private int count(char[][] board, int x, int y) {
        int res = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                
                int nextX = x + i, nextY = y + j;
                if (inBound(nextX, nextY, board) && board[nextX][nextY] == 'M') {
                    res++;
                }
            }
        }
        
        return res;
    }
    
    private boolean inBound(int x, int y, char[][] board) {
        return 0 <= x && x < board.length && 0 <= y && y < board[0].length;
    }
    
    public static void main(String[] args) {
        char[][] b = {
                "EEEEE".toCharArray(),
                "EEMEE".toCharArray(),
                "EEEEE".toCharArray(),
                "EEEEE".toCharArray()};
        System.out.println(Arrays.deepToString(new Solution().updateBoard(b, new int[]{3, 0})));
    }
}
