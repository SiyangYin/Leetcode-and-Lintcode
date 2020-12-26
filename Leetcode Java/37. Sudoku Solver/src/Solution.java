import java.util.Arrays;

public class Solution {
    
    public static void main(String[] args) {
        char[][] board = new char[9][9];
        board[0] = new char[]{'5', '3', '.', '.', '7', '.', '.', '.', '.'};
        board[1] = new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'};
        board[2] = new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'};
        board[3] = new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'};
        board[4] = new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'};
        board[5] = new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'};
        board[6] = new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'};
        board[7] = new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'};
        board[8] = new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'};
        
        new Solution().solveSudoku(board);
        
        for (int i = 0; i < 9; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }
    
    public void solveSudoku(char[][] board) {
        dfs(board, 0);
    }
    
    private boolean dfs(char[][] board, int pos) {
        while (pos < 81 && board[pos / 9][pos % 9] != '.') {
            pos++;
        }
        if (pos == 81) {
            return true;
        }
        
        for (int i = 1; i <= 9; i++) {
            board[pos / 9][pos % 9] = (char) ('0' + i);
            if (check(board, pos) && dfs(board, pos + 1)) {
                return true;
            }
            
            board[pos / 9][pos % 9] = '.';
        }
        
        return false;
    }
    
    private boolean check(char[][] board, int pos) {
        int row = pos / 9, col = pos % 9;
        
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == board[row][col] && i != col) {
                return false;
            }
            if (board[i][col] == board[row][col] && i != row) {
                return false;
            }
        }
        
        int i = row / 3 * 3, j = col / 3 * 3;
        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                if (board[i + k][j + l] == board[row][col] && i + k != row && j + l != col) {
                    return false;
                }
            }
            
        }
        
        return true;
    }
}
