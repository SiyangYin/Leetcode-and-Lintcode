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
    
    private void reset(Robot robot) {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
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