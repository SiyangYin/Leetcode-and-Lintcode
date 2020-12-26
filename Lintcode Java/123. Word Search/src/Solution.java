public class Solution {
    /**
     * @param board: A list of lists of character
     * @param word: A string
     * @return: A boolean
     */
    public boolean exist(char[][] board, String word) {
        // write your code here
        if (word == null || word.isEmpty()) {
            return false;
        }
        
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean[][] visited = new boolean[board.length][board[0].length];
    
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, 0, i, j, visited, dirs)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int pos, int x, int y, boolean[][] visited, int[][] dirs) {
        if (board[x][y] != word.charAt(pos)) {
            return false;
        }
    
        if (pos == word.length() - 1) {
            return true;
        }
        
        visited[x][y] = true;
        for (int i = 0; i < dirs.length; i++) {
            int nextX = x + dirs[i][0], nextY = y + dirs[i][1];
            if (inBoard(board, nextX, nextY) && !visited[nextX][nextY]) {
                if (dfs(board, word, pos + 1, nextX, nextY, visited, dirs)) {
                    return true;
                }
            }
        }
        visited[x][y] = false;
        
        return false;
    }
    
    private boolean inBoard(char[][] board, int x, int y) {
        return 0 <= x && x < board.length && 0 <= y && y < board[0].length;
    }
}
