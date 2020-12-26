import java.util.Arrays;

public class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        
        int m = board.length, n = board[0].length;
        int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0, d, '#');
            }
            if (board[i][n - 1] == 'O') {
                dfs(board, i, n - 1, d, '#');
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                dfs(board, 0, i, d, '#');
            }
            if (board[m - 1][i] == 'O') {
                dfs(board, m - 1, i, d, '#');
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    dfs(board, i, j, d, 'X');
                }
            }
        }
    
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
        
    }
    
    private void dfs(char[][] board, int x, int y, int[][] d, char mark) {
        board[x][y] = mark;
        for (int i = 0; i < 4; i++) {
            int newX = x + d[i][0];
            int newY = y + d[i][1];
            if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length && board[newX][newY] == 'O') {
                dfs(board, newX, newY, d, mark);
            }
        }
    }
    
    public static void main(String[] args) {
        char[][] board = {{'O', 'O', 'O'}, {'O', 'O', 'O'}, {'O', 'O', 'O'}};
        
        new Solution().solve(board);
    
        System.out.println(Arrays.deepToString(board));
    }
}
