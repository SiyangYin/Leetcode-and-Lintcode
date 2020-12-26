import java.util.*;

public class Solution {
    public int slidingPuzzle(int[][] board) {
        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> visited = new HashMap<>();
        
        String init = boardToString(board);
        if (init.equals("123450")) {
            return 0;
        }
        
        queue.offer(init);
        visited.put(init, 0);
        
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            List<String> nexts = getNexts(cur);
    
            for (String next : nexts) {
                if (!visited.containsKey(next)) {
                    if (next.equals("123450")) {
                        return visited.get(cur) + 1;
                    }
                    
                    queue.offer(next);
                    visited.put(next, visited.get(cur) + 1);
                }
            }
        }
        
        return -1;
    }
    
    private List<String> getNexts(String s) {
        int[][] cur = stringToBoard(s);
        int zero;
        for (zero = 0; zero < 6; zero++) {
            if (cur[zero / 3][zero % 3] == 0) {
                break;
            }
        }
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        
        List<String> res = new ArrayList<>();
        int zx = zero / 3, zy = zero % 3;
        for (int i = 0; i < 4; i++) {
            int nextx = zx + dirs[i][0], nexty = zy + dirs[i][1];
            if (inBoard(nextx, nexty)) {
                swap(cur, zx, zy, nextx, nexty);
                res.add(boardToString(cur));
                // 恢复成原来的状态
                swap(cur, zx, zy, nextx, nexty);
            }
        }
        
        return res;
    }
    
    private void swap(int[][] board, int x1, int y1, int x2, int y2) {
        int tmp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = tmp;
    }
    
    private boolean inBoard(int x, int y) {
        return 0 <= x && x < 2 && 0 <= y && y < 3;
    }
    
    private int[][] stringToBoard(String s) {
        int[][] board = new int[2][3];
        for (int i = 0; i < s.length(); i++) {
            board[i / 3][i % 3] = s.charAt(i) - '0';
        }
        return board;
    }
    
    private String boardToString(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                sb.append(board[i][j]);
            }
        }
        
        return sb.toString();
    }
}
