public class Solution {
    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                change(board, i, j);
            }
        }
    
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] >>= 1;
            }
        }
    }
    
    private void change(int[][] board, int x, int y) {
        int live = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                
                if (0 <= x + i && x + i < board.length && 0 <= y + j && y + j < board[0].length) {
                    if ((board[x + i][y + j] & 1) == 1) {
                        live++;
                    }
                }
            }
        }
        
        if ((board[x][y] & 1) == 1) {
            if (2 <= live && live <= 3) {
                board[x][y] = 3;
            }
        } else {
            if (live == 3) {
                board[x][y] = 2;
            }
        }
    }
}
