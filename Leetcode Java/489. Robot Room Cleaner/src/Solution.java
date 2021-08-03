import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Solution {
    
    class Pair {
        private int x, y;
        
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
    
    public void cleanRoom(Robot robot) {
        dfs(0, 0, new HashSet<>(), 0, new int[]{-1, 0, 1, 0, -1}, robot);
    }
    
    private void dfs(int x, int y, Set<Pair> vis, int dir, int[] d, Robot robot) {
        vis.add(new Pair(x, y));
        robot.clean();
        for (int i = 0; i < 4; i++) {
            int nextDir = (dir + i) % 4;
            int nextX = x + d[nextDir], nextY = y + d[nextDir + 1];
            Pair next = new Pair(nextX, nextY);
            if (!vis.contains(next) && robot.move()) {
                dfs(nextX, nextY, vis, nextDir, d, robot);
                reset(robot);
            }
            
            robot.turnRight();
        }
    }
    
    public static void main(String[] args) {
        int[][] g = {{0, 0}, {0, -1}};
        Robot robot = new RobotImpl(g, 0, 0);
        new Solution().cleanRoom(robot);
    }
    
    private void reset(Robot robot) {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
}

class RobotImpl implements Robot {
    
    final int BLOCK= -1, EMPTY = 0, CLEANED = 1;
    int[][] g;
    int dir;
    int x, y;
    int[] d = {-1, 0, 1, 0, -1};
    
    public RobotImpl(int[][] g, int x, int y) {
        this.g = g;
        this.x = x;
        this.y = y;
    }
    
    @Override
    public boolean move() {
        int nextX = x + d[dir], nextY = y + d[dir + 1];
        if (0 <= nextX && nextX < g.length && 0 <= nextY && nextY < g[0].length && g[nextX][nextY] != BLOCK) {
            x = nextX;
            y = nextY;
            return true;
        }
        
        return false;
    }
    
    @Override
    public void turnLeft() {
        dir = (dir + 3) % 4;
    }
    
    @Override
    public void turnRight() {
        dir = (dir + 1) % 4;
    }
    
    @Override
    public void clean() {
        g[x][y] = CLEANED;
    }
}

interface Robot {
    // Returns true if the cell in front is open and robot moves into the cell.
    // Returns false if the cell in front is blocked and robot stays in the current cell.
    boolean move();
    
    // Robot will stay in the same cell after calling turnLeft/turnRight.
    // Each turn will be 90 degrees.
    void turnLeft();
    
    void turnRight();
    
    // Clean the current cell.
    void clean();
}