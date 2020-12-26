public class TicTacToe {
    /**
     * Initialize your data structure here.
     */
    public TicTacToe() {
    
    }
    
    public boolean move(int row, int col) throws AlreadyTakenException, GameEndException {
        return true;
    }
}

class AlreadyTakenException extends RuntimeException {

}

class GameEndException extends RuntimeException {

}