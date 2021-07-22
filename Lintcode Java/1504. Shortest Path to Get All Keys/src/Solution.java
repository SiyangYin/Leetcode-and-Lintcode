import java.util.*;

public class Solution {
    
    class Pair {
        int x, y, state;
        
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public boolean equals(Object o) {
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y && state == pair.state;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(x, y, state);
        }
    }
    
    /**
     * @param grid:
     * @return: The lowest number of moves to acquire all keys
     */
    public int shortestPathAllKeys(String[] grid) {
        // write your code here
        Queue<Pair> queue = new LinkedList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, id = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                char ch = grid[i].charAt(j);
                if (ch == '@') {
                    queue.offer(new Pair(i, j));
                }
                
                if (Character.isLowerCase(ch) && !map.containsKey(ch)) {
                    map.put(ch, id++);
                }
            }
        }
        
        if (map.isEmpty()) {
            return 0;
        }
        
        int res = 0;
        int[] d = {-1, 0, 1, 0, -1};
        Set<Pair> vis = new HashSet<>();
        vis.add(queue.peek());
        
        while (!queue.isEmpty()) {
            res++;
            for (int i = queue.size(); i >= 1; i--) {
                Pair cur = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int nextX = cur.x + d[k], nextY = cur.y + d[k + 1];
                    if (inBound(nextX, nextY, grid)) {
                        char ch = grid[nextX].charAt(nextY);
                        if (ch == '#') {
                            continue;
                        }
                        
                        if (Character.isUpperCase(ch) && (cur.state >> map.get(Character.toLowerCase(ch)) & 1) == 0) {
                            continue;
                        }
                        
                        Pair next = new Pair(nextX, nextY);
                        next.state = cur.state;
                        if (Character.isLowerCase(ch)) {
                            next.state |= 1 << map.get(ch);
                            if (next.state == (1 << map.size()) - 1) {
                                return res;
                            }
                        }
                        
                        if (!vis.contains(next)) {
                            vis.add(next);
                            queue.offer(next);
                        }
                    }
                }
            }
        }
        
        return -1;
    }
    
    private boolean inBound(int x, int y, String[] g) {
        return 0 <= x && x < g.length && 0 <= y && y < g[0].length();
    }
    
    public static void main(String[] args) {
        String[] g = {"@..aA", "..B#.", "....b"};
        System.out.println(new Solution().shortestPathAllKeys(g));
    }
}
