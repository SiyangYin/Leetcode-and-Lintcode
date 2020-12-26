public class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
    
        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, word, 0, direction)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean dfs(char[][] board, int x, int y, String word, int pos, int[][] direction) {
        if (board[x][y] != word.charAt(pos)) {
            return false;
        }
        
        if (pos == word.length() - 1) {
            return true;
        }
        
        board[x][y] = '.';
    
        for (int i = 0; i < 4; i++) {
            int a = x + direction[i][0], b = y + direction[i][1];
            if (a >= 0 && a < board.length && b >= 0 && b < board[0].length) {
                if (dfs(board, a, b, word, pos + 1, direction)) {
                    return true;
                }
            }
        }
        board[x][y] = word.charAt(pos);
        
        return false;
    }
    
    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'D'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(new Solution().exist(board, "ABCCED"));
    }
}
