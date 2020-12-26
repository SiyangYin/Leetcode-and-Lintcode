import java.util.ArrayList;
import java.util.List;

public class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        
        dfs(click[0], click[1], board, new boolean[board.length][board[0].length], dirs);
        return board;
    }
    
    private void dfs(int x, int y, char[][] board, boolean[][] visited, int[][] dirs) {
        visited[x][y] = true;
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return;
        }
    
        List<int[]> adj = getAdj(x, y, board, dirs, visited);
        if (!adj.isEmpty() && adj.get(0)[0] == -1) {
            board[x][y] = (char) ('0' + adj.get(0)[1]);
            return;
        }
        
        board[x][y] = 'B';
        for (int[] next : adj) {
            dfs(next[0], next[1], board, visited, dirs);
        }
    }
    
    private List<int[]> getAdj(int x, int y, char[][] board, int[][] dirs, boolean[][] visited) {
        List<int[]> nexts = new ArrayList<>();
        int mines = 0;
        for (int i = 0; i < dirs.length; i++) {
            int nextX = x + dirs[i][0], nextY = y + dirs[i][1];
            if (inBoard(nextX, nextY, board) && !visited[nextX][nextY]) {
                if (board[nextX][nextY] == 'M') {
                    mines++;
                } else {
                    nexts.add(new int[]{nextX, nextY});
                }
            }
        }
        
        if (mines != 0) {
            nexts.clear();
            nexts.add(new int[]{-1, mines});
        }
        
        return nexts;
    }
    
    private boolean inBoard(int x, int y, char[][] board) {
        return 0 <= x && x < board.length && 0 <= y && y < board[0].length;
    }
    
    public static void main(String[] args) {
        char[][] board = {
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}};
        int[] click = {3, 0};
        new Solution().updateBoard(board, click);
        for (char[] chars : board) {
            System.out.println(chars);
        }
    }
}
