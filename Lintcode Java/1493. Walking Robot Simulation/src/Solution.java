import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Solution {
    
    class Pair {
        int x, y;
        
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public boolean equals(Object o) {
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    
    /**
     * @param commands:  type: List[int]
     * @param obstacles: type: List[List[int]]
     * @return: Return the square of the maximum Euclidean distance
     */
    public int robotSim(int[] commands, int[][] obstacles) {
        // write your code here
        int x = 0, y = 0;
        int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dir = 0;
        
        Set<Pair> obs = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obs.add(new Pair(obstacle[0], obstacle[1]));
        }
        
        int res = 0;
        for (int command : commands) {
            if (command == -1) {
                dir = (dir + 1) % 4;
            } else if (command == -2) {
                dir = (dir + 3) % 4;
            } else {
                int dx = d[dir][0], dy = d[dir][1];
                for (int i = 0; i < command; i++) {
                    if (!obs.contains(new Pair(x + dx, y + dy))) {
                        x += dx;
                        y += dy;
                    } else {
                        break;
                    }
                    
                    res = Math.max(res, x * x + y * y);
                }
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[] co = {4, -1, 4, -2, 4};
        int[][] ob = {{2,4}};
        System.out.println(new Solution().robotSim(co, ob));
    }
}
