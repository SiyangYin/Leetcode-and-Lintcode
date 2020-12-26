import java.util.*;

public class Solution {
    /**
     * @param grid:        a chessboard included 0 (false) and 1 (true)
     * @param source:      a point
     * @param destination: a point
     * @return: the shortest path
     */
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        // write your code here
        if (pointToString(source).equals(pointToString(destination))) {
            return 0;
        }
        if (grid[source.x][source.y] || grid[destination.x][destination.y]) {
            return -1;
        }
        
        Queue<Point> beginQueue = new LinkedList<>();
        Set<String> beginSet = new HashSet<>();
        beginQueue.offer(source);
        beginSet.add(pointToString(source));
        
        Queue<Point> endQueue = new LinkedList<>();
        Set<String> endSet = new HashSet<>();
        endQueue.offer(destination);
        endSet.add(pointToString(destination));
        
        int step = 0;
        while (!beginQueue.isEmpty() && !endQueue.isEmpty()) {
            int beginSize = beginQueue.size(), endSize = endQueue.size();
            step++;
            for (int i = 0; i < beginSize; i++) {
                Point head = beginQueue.poll();
                for (Point next : getNexts(head, grid)) {
                    if (endSet.contains(pointToString(next))) {
                        return step;
                    }
                    if (!beginSet.contains(pointToString(next))) {
                        beginQueue.offer(next);
                        beginSet.add(pointToString(next));
                    }
                }
            }
            
            step++;
            for (int i = 0; i < endSize; i++) {
                Point head = endQueue.poll();
                for (Point next : getNexts(head, grid)) {
                    if (beginSet.contains(pointToString(next))) {
                        return step;
                    }
                    if (!endSet.contains(pointToString(next))) {
                        endQueue.offer(next);
                        endSet.add(pointToString(next));
                    }
                }
            }
        }
        
        return -1;
    }
    
    private List<Point> getNexts(Point p, boolean[][] grid) {
        int[][] dirs = {{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};
        List<Point> neighbors = new ArrayList<>();
        for (int i = 0; i < dirs.length; i++) {
            int X = p.x + dirs[i][0];
            int Y = p.y + dirs[i][1];
            if (inBound(X, Y, grid) && !grid[X][Y]) {
                neighbors.add(new Point(X, Y));
            }
        }
        return neighbors;
    }
    
    private boolean inBound(int x, int y, boolean[][] grid) {
        return 0 <= x && x < grid.length && 0 <= y && y < grid[0].length;
    }
    
    private String pointToString(Point p) {
        return p.x + " " + p.y;
    }
    
    public static void main(String[] args) {
        boolean[][] grid = {
                {false, true, false},
                {false, false, true},
                {false, false, false}};
        
        Point source = new Point(2, 0);
        Point destination = new Point(2, 2);
        System.out.println(new Solution().shortestPath(grid, source, destination));
    }
}

class Point {
    
    int x, y;
    
    Point() {
        x = y = 0;
    }
    
    Point(int a, int b) {
        x = a;
        y = b;
    }
}