import java.util.HashSet;
import java.util.Set;

public class Solution {
    /**
     * @param board: the board
     * @return: whether the Sudoku is valid
     */
    public boolean isValidSudoku(char[][] board) {
        // write your code here
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.' && !set.add(board[i][j])) {
                    return false;
                }
            }
            set.clear();
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[j][i] != '.' && !set.add(board[j][i])) {
                    return false;
                }
            }
            set.clear();
        }
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 9; k++) {
                    int x = i * 3 + k / 3, y = j * 3 + k % 3;
                    if (board[x][y] != '.' && !set.add(board[x][y])) {
                        return false;
                    }
                }
                set.clear();
            }
        }
        
        return true;
    }
}
