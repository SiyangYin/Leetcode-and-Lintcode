public class Solution {
    public boolean validTicTacToe(String[] board) {
        if (board == null || board.length == 0 || board[0].length() == 0) {
            return true;
        }
        
        int n = board.length;
        int[] rows = new int[n], cols = new int[n];
        int diag = 0, antidiag = 0;
        int ocount = 0, xcount = 0;
        boolean owin = false, xwin = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                char ch = board[i].charAt(j);
                rows[i] += mapping(ch);
                cols[j] += mapping(ch);
                if (i == j) {
                    diag += mapping(ch);
                }
                if (i + j == n - 1) {
                    antidiag += mapping(ch);
                }
                
                if (ch == 'X') {
                    xcount++;
                } else if (ch == 'O') {
                    ocount++;
                }
                
                if (rows[i] == n || cols[j] == n || diag == n || antidiag == n) {
                    owin = true;
                }
    
                if (rows[i] == -n || cols[j] == -n || diag == -n || antidiag == -n) {
                    xwin = true;
                }
            }
        }
        
        if (xcount < ocount || xcount > ocount + 1) {
            return false;
        }
        
        if (xcount == ocount && xwin) {
            return false;
        }
        
        if (xcount == ocount && owin) {
            return false;
        }
        
        if (xwin && owin) {
            return false;
        }
        
        return true;
    }
    
    private int mapping(char c) {
        if (c == 'X') {
            return -1;
        } else if (c == 'O') {
            return 1;
        } else {
            return 0;
        }
    }
}
