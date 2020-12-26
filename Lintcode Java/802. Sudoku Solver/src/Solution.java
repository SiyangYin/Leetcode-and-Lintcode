import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param board: the sudoku puzzle
     * @return: nothing
     */
    public void solveSudoku(int[][] board) {
        // write your code here
        dfs(board, 0);
    }
    
    private boolean dfs(int[][] board, int start) {
        int n = board.length;
        while (start < n * n && board[start / n][start % n] != 0) {
            start++;
        }
        
        if (start == n * n) {
            return true;
        }
        
        int x = start / n, y = start % n;
        
        for (int num : validNums(board, x, y)) {
            board[x][y] = num;
            if (dfs(board, start + 1)) {
                return true;
            }
            board[x][y] = 0;
        }
        
        return false;
    }
    
    private List<Integer> validNums(int[][] board, int x, int y) {
        List<Integer> res = new ArrayList<>();
        
        for (int n = 1; n <= 9; n++) {
            boolean valid = true;
            for (int i = 0; i < board.length; i++) {
                if (i != y && board[x][i] == n) {
                    valid = false;
                    break;
                }
                if (i != x && board[i][y] == n) {
                    valid = false;
                    break;
                }
            }
            if (!valid) {
                continue;
            }
            
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int c1 = x / 3 * 3, c2 = y / 3 * 3;
                    if (c1 + i != x && c2 + j != y && board[c1 + i][c2 + j] == n) {
                        valid = false;
                        break;
                    }
                }
                if (!valid) {
                    break;
                }
            }
            
            if (valid) {
                res.add(n);
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[][] board = {
                {0, 0, 9, 7, 4, 8, 0, 0, 0},
                {7, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 2, 0, 1, 0, 9, 0, 0, 0},
                {0, 0, 7, 0, 0, 0, 2, 4, 0},
                {0, 6, 4, 0, 1, 0, 5, 9, 0},
                {0, 9, 8, 0, 0, 0, 3, 0, 0},
                {0, 0, 0, 8, 0, 3, 0, 2, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 6},
                {0, 0, 0, 2, 7, 5, 9, 0, 0}};
        
        new Solution().solveSudoku(board);
    }
}
