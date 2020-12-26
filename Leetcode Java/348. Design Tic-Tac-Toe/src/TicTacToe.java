public class TicTacToe {
    
    private int[] rows, cols;
    private int diag, antidiag;
    private int size;
    
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        this.size = n;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int add = player * 2 - 3;
        
        rows[row] += add;
        cols[col] += add;
        
        if (row == col) {
            diag += add;
        }
        if (row + col == size - 1) {
            antidiag += add;
        }
        
        if (rows[row] == size || cols[col] == size || diag == size || antidiag == size) {
            return 2;
        } else if (rows[row] == -size || cols[col] == -size || diag == -size || antidiag == -size) {
            return 1;
        } else {
            return 0;
        }
    }
    
    public static void main(String[] args) {
        TicTacToe tt = new TicTacToe(3);
        tt.move(1,1,2);
        tt.move(0,2,2);
        System.out.println(tt.move(2, 0, 2));
    }
}
