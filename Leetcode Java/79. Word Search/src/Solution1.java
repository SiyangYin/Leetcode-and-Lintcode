public class Solution1 {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, word, new boolean[board.length][board[0].length], i, j, 0)) return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, boolean[][] used, int i, int j, int k) {
        if (board[i][j] != word.charAt(k)) return false;
        else if (k == word.length() - 1) return true;
        used[i][j] = true;
        if (i - 1 >= 0 && !used[i - 1][j] && dfs(board, word, used, i - 1, j, k + 1)) return true;
        if (i + 1 < board.length && !used[i + 1][j] && dfs(board, word, used, i + 1, j, k + 1)) return true;
        if (j - 1 >= 0 && !used[i][j - 1] && dfs(board, word, used, i, j - 1, k + 1)) return true;
        if (j + 1 < board[0].length && !used[i][j + 1] && dfs(board, word, used, i, j + 1, k + 1)) return true;
        used[i][j] = false;
        return false;
    }
    
    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'D'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        // char[][] board = {{'A'}};
        System.out.println(new Solution1().exist(board, "ABFSA"));
    }
}
