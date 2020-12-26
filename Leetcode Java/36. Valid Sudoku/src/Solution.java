import java.util.Arrays;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!checkRowColumn(board, i, i)) {
                return false;
            }
        }
    
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!checkBlock(board, i, j)) {
                    return false;
                }
            }
        }
        
        return true;
        
    }
    
    boolean checkRowColumn(char[][] board, int i, int j) {
        int[] count = new int[9];
        int index = 0;
        for (int k = 0; k < 9; k++) {
            if (board[i][k] == '.') {
                continue;
            }
            index = board[i][k] - '1';
            count[index]++;
            if (count[index] >= 2) {
                return false;
            }
        }
    
        Arrays.fill(count, 0);
        for (int k = 0; k < 9; k++) {
            if (board[k][j] == '.') {
                continue;
            }
            index = board[k][j] - '1';
            count[index]++;
            if (count[index] >= 2) {
                return false;
            }
        }
        
        return true;
    }
    
    boolean checkBlock(char[][] board, int i, int j) {
        int[] count = new int[9];
        int index = 0;
        for (int k = i; k < i + 3; k++) {
            for (int l = j; l < j + 3; l++) {
                if (board[k][l] == '.') {
                    continue;
                }
                index = board[k][l] - '1';
                count[index]++;
                if (count[index] >= 2) {
                    return false;
                }
            }
        }
        return true;
    }
}

