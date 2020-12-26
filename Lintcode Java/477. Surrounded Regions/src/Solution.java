import java.util.Arrays;

public class Solution {
    /*
     * @param board: board a 2D board containing 'X' and 'O'
     * @return: nothing
     */
    public void surroundedRegions(char[][] board) {
        // write your code here
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        
        int m = board.length, n = board[0].length;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                dfs(i, 0, board, '#', dirs);
            }
            if (board[i][n - 1] == 'O') {
                dfs(i, n - 1, board, '#', dirs);
            }
        }
    
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                dfs(0, i, board, '#', dirs);
            }
            if (board[m - 1][i] == 'O') {
                dfs(m - 1, i, board, '#', dirs);
            }
        }
    
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (board[i][j] == 'O') {
                    dfs(i, j, board, 'X', dirs);
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
    
    private void dfs(int x, int y, char[][] board, char to, int[][] dirs) {
        board[x][y] = to;
        for (int i = 0; i < dirs.length; i++) {
            int nextX = x + dirs[i][0], nextY = y + dirs[i][1];
            if (inBound(nextX, nextY, board) && board[nextX][nextY] == 'O') {
                dfs(nextX, nextY, board, to, dirs);
            }
        }
    }
    
    private boolean inBound(int x, int y, char[][] board) {
        return 0 <= x && x < board.length && 0 <= y && y < board[0].length;
    }
    
    public static void main(String[] args) {
        char[][] board = {
                "XXXXX".toCharArray(),
                "XXXXX".toCharArray(),
                "XXOOX".toCharArray(),
                "XXOXX".toCharArray(),
                "XXOXX".toCharArray()};
        new Solution().surroundedRegions(board);
        System.out.println(Arrays.deepToString(board));
    }
}
