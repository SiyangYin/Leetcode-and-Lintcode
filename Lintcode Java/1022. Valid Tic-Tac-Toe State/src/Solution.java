public class Solution {
    /**
     * @param board: the given board
     * @return: True if and only if it is possible to reach this board position during the course of a valid tic-tac-toe game
     */
    public boolean validTicTacToe(String[] board) {
        // Write your code
        int xCount = 0, oCount = 0;
        int[] row = new int[3], col = new int[3];
        int diag = 0, antidiag = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                char ch = board[i].charAt(j);
                if (ch == 'X') {
                    xCount++;
                    row[i]++;
                    col[j]++;
                    if (i == j) {
                        diag++;
                    }
                    if (i + j == 2) {
                        antidiag++;
                    }
                } else if (ch == 'O') {
                    oCount++;
                    row[i]--;
                    col[j]--;
                    if (i == j) {
                        diag--;
                    }
                    if (i + j == 2) {
                        antidiag--;
                    }
                }
            }
        }
        
        if (oCount > xCount || xCount - oCount >= 2) {
            return false;
        }
        
        boolean oWin = false, xWin = false;
        for (int i = 0; i < 3; i++) {
            if (row[i] == 3 || col[i] == 3) {
                xWin = true;
            }
            if (row[i] == -3 || col[i] == -3) {
                oWin = true;
            }
        }
        if (diag == 3 || antidiag == 3) {
            xWin = true;
        }
        if (diag == -3 || antidiag == -3) {
            oWin = true;
        }
        
        if (xCount == oCount) {
            return !xWin;
        } else {
            return !oWin;
        }
    }
}
