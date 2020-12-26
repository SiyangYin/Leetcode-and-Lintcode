import java.util.*;

public class Solution {
    
    class State {
        int x, y;
        int keyState;
        
        public State(int x, int y, int keyState) {
            this.x = x;
            this.y = y;
            this.keyState = keyState;
        }
        
        @Override
        public boolean equals(Object o) {
            State state = (State) o;
            return x == state.x && y == state.y && keyState == state.keyState;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(x, y, keyState);
        }
    }
    
    public int shortestPathAllKeys(String[] grid) {
        State start = new State(0, 0, 0);
        char maxKey = 'a', maxLock = 'A';
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                char ch = grid[i].charAt(j);
                if (ch == '@') {
                    start.x = i;
                    start.y = j;
                } else if (ch != '.') {
                    if (Character.isLowerCase(ch)) {
                        maxKey = (char) Math.max(maxKey, ch);
                    } else {
                        maxLock = (char) Math.max(maxLock, ch);
                    }
                }
            }
        }
        
        int fullKey = (1 << (maxKey - 'a' + 1)) - 1;
        
        Queue<State> queue = new LinkedList<>();
        queue.offer(start);
        Set<State> visited = new HashSet<>();
        visited.add(start);
        
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                State cur = queue.poll();
                for (State next : getNexts(cur, grid, visited, maxKey, maxLock)) {
                    if (next.keyState == fullKey) {
                        return step;
                    }
                    
                    visited.add(next);
                    queue.offer(next);
                }
            }
        }
        
        return -1;
    }
    
    private List<State> getNexts(State cur, String[] grid, Set<State> visited, char maxKey, char maxLock) {
        List<State> nexts = new ArrayList<>();
        int[] d = {1, 0, -1, 0, 1};
        for (int i = 0; i < 4; i++) {
            int nextX = cur.x + d[i], nextY = cur.y + d[i + 1];
            if (inBound(nextX, nextY, grid)) {
                State next = new State(nextX, nextY, cur.keyState);
                char ch = grid[nextX].charAt(nextY);
                if (ch == '#') {
                    continue;
                }
                
                if ('a' <= ch && ch <= maxKey) {
                    next.keyState |= (1 << (ch - 'a'));
                }
                
                if ('A' <= ch && ch <= maxLock && ((cur.keyState >> (ch - 'A')) & 1) != 1) {
                    continue;
                }
                
                if (!visited.contains(next)) {
                    nexts.add(next);
                }
            }
        }
        
        return nexts;
    }
    
    private boolean inBound(int x, int y, String[] grid) {
        return 0 <= x && x < grid.length && 0 <= y && y < grid[0].length();
    }
    
    
    public static void main(String[] args) {
        // System.out.println(1 << 4 - 2);
        // System.out.println(new Solution().shortestPathAllKeys(new String[]{"@.a.#", "###.#", "b.A.B"}));
        System.out.println(new Solution().shortestPathAllKeys(new String[]{
                "@...a",
                ".###A",
                "b.BCc"}));
    }
}
