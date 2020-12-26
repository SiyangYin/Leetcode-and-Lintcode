import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Solution {
    
    class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        int square() {
            return x * x + y * y;
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
    
    public int robotSim(int[] commands, int[][] obstacles) {
        int res = 0;
        int[] dir = {0, 1, 0, -1};
        int curDir = 0;
    
        Set<Pair> obs = new HashSet<>();
        for (int i = 0; i < obstacles.length; i++) {
            obs.add(new Pair(obstacles[i][0], obstacles[i][1]));
        }
    
        Pair cur = new Pair(0, 0);
        for (int i = 0; i < commands.length; i++) {
            if (commands[i] == -1) {
                curDir = (curDir + 1) % 4;
            } else if (commands[i] == -2) {
                curDir = (curDir + 3) % 4;
            } else {
                int dx = dir[curDir], dy = dir[(curDir + 1) % 4];
                for (int j = 0; j < commands[i]; j++) {
                    if (obs.contains(new Pair(cur.x + dx, cur.y + dy))) {
                        break;
                    }
                    cur.x += dx;
                    cur.y += dy;
                }
            }
            
            res = Math.max(res, cur.square());
        }
        
        // System.out.println(cur.x + " " + cur.y);
        return res;
    }
    
    public static void main(String[] args) {
        int[][] obs = {{2, 4}};
        System.out.println(new Solution().robotSim(new int[]{4, -1, 4, -2, 4}, obs));
    }
}
