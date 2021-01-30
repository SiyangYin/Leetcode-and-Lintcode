import java.util.HashSet;
import java.util.Set;

public class Solution {
    public void cleanRoom(Robot robot) {
        // write tour code here
        int[] d = {1, 0, -1, 0, 1};
        dfs(0, 0, d, 0, new HashSet<>(), robot);
    }
    
    private void dfs(int x, int y, int[] d, int curD, Set<String> visited, Robot robot) {
        String loc = x + " " + y;
        if (visited.contains(loc)) {
            return;
        }
        
        visited.add(loc);
        robot.clean();
        for (int i = 0; i < 4; i++) {
            if (robot.move()) {
                dfs(x + d[curD], y + d[curD + 1], d, curD, visited, robot);
                goBack(robot);
            }
            
            robot.turnRight();
            curD = (curD + 1) % 4;
        }
    }
    
    private void goBack(Robot robot) {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnLeft();
        robot.turnLeft();
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