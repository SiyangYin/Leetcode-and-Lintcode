import java.util.*;

public class Solution {
    /**
     * @param board: the given board
     * @return: the least number of moves required so that the state of the board is solved
     */
    public int slidingPuzzle(int[][] board) {
        // write your code here
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                sb.append(board[i][j]);
            }
        }
        String start = sb.toString();
        String end = "123450";
        
        if (start.equals(end)) {
            return 0;
        }
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        Set<String> visited = new HashSet<>();
        visited.add(start);
        
        int res = 0;
        while (!queue.isEmpty()) {
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                for (String next : getNexts(cur, visited)) {
                    if (next.equals(end)) {
                        return res;
                    }
                    
                    visited.add(next);
                    queue.offer(next);
                }
            }
        }
        
        return -1;
    }
    
    private List<String> getNexts(String cur, Set<String> visited) {
        StringBuilder state = new StringBuilder(cur);
        
        int[] d = {1, 0, -1, 0, 1};
        int x = 0, y = 0;
        for (int i = 0; i < cur.length(); i++) {
            if (cur.charAt(i) == '0') {
                x = i / 3;
                y = i % 3;
                break;
            }
        }
        
        List<String> nexts = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int nextX = x + d[i], nextY = y + d[i + 1];
            if (0 <= nextX && nextX < 2 && 0 <= nextY && nextY < 3) {
                int swapPosition = nextX * 3 + nextY;
                swap(state, getPos(x, y), getPos(nextX, nextY));
                String nextState = state.toString();
                if (!visited.contains(nextState)) {
                    nexts.add(nextState);
                }
                swap(state, getPos(x, y), getPos(nextX, nextY));
            }
        }
        
        return nexts;
    }
    
    private int getPos(int x, int y) {
        return x * 3 + y;
    }
    
    private void swap(StringBuilder sb, int i, int j) {
        char tmp = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, tmp);
    }
    
    public static void main(String[] args) {
        int[][] b = {{4, 1, 2}, {5, 0, 3}};
        System.out.println(new Solution().slidingPuzzle(b));
        
        StringBuilder sb = new StringBuilder("123");
        new Solution().swap(sb, 1, 2);
        System.out.println(sb);
    }
}
