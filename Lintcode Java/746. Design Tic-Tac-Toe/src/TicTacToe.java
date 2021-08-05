import java.util.Arrays;

public class TicTacToe {
    
    private char[][] board;
    private char currentPlayer;
    private boolean end;
    
    /**
     * Initialize your data structure here.
     */
    public TicTacToe() {
        board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
        currentPlayer = 'O';
        end = false;
    }
    
    public boolean move(int row, int col) throws AlreadyTakenException, GameEndException {
        if (end) {
            throw new GameEndException();
        }
        if (board[row][col] != '-') {
            throw new AlreadyTakenException();
        }
        
        board[row][col] = currentPlayer;
        char[] r = {currentPlayer, currentPlayer, currentPlayer};
        for (char[] chs : board) {
            if (Arrays.equals(chs, r)) {
                end = true;
                return true;
            }
        }
        
        for (int i = 0; i < 3; i++) {
            char[] chs = {board[0][i], board[1][i], board[2][i]};
            if (Arrays.equals(chs, r)) {
                end = true;
                return true;
            }
        }
        
        if (Arrays.equals(r, new char[]{board[0][0], board[1][1], board[2][2]})) {
            end = true;
            return true;
        }
        
        if (Arrays.equals(r, new char[]{board[0][2], board[1][1], board[2][0]})) {
            end = true;
            return true;
        }
        
        checkBoardFull();
        changePlayer();
        return false;
    }
    
    private void changePlayer() {
        currentPlayer = currentPlayer == 'O' ? 'X' : 'O';
    }
    
    private void checkBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return;
                }
            }
        }
        
        end = true;
    }
}

class AlreadyTakenException extends RuntimeException {
    public AlreadyTakenException() {
        super("This place has been taken");
    }
}

class GameEndException extends RuntimeException {
    public GameEndException() {
        super("Game has been ended, cannot make any more moves");
    }
}