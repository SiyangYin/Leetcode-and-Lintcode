import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution {
    class Point {
        int x, y, value;
        Point(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    
        @Override
        public boolean equals(Object o) {
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }
    
        @Override
        public int hashCode() {
            return 31 * x + y;
        }
    }
    /**
     * @param matrix: a matrix of integers
     * @param k: An integer
     * @return: the kth smallest number in the matrix
     */
    public int kthSmallest(int[][] matrix, int k) {
        // write your code here
        PriorityQueue<Point> minHeap = new PriorityQueue<>((p1, p2) -> p1.value <= p2.value ? -1 : 1);
        Set<Point> visited = new HashSet<>();
        Point p0 = new Point(0, 0, matrix[0][0]);
        minHeap.offer(p0);
        visited.add(p0);
        int count = 0;
        while (!minHeap.isEmpty()) {
            Point cur = minHeap.poll();
            count++;
            if (count == k) {
                return cur.value;
            }
            for (Point point : generate(cur, matrix, visited)) {
                minHeap.offer(point);
            }
        }
        
        return -1;
    }
    
    private Set<Point> generate(Point z, int[][] matrix, Set<Point> visited) {
        Set<Point> neighbors = new HashSet<>();
        int[][] dirs = {{0, 1}, {1, 0}};
        for (int i = 0; i < dirs.length; i++) {
            int x = z.x + dirs[i][0];
            int y = z.y + dirs[i][1];
            if (0 <= x && x < matrix.length && 0 <= y && y < matrix[0].length) {
                Point neighbor = new Point(x, y, matrix[x][y]);
                if (!visited.contains(neighbor)) {
                    neighbors.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        
        return neighbors;
    }
    
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 5, 7},
                {3, 7, 8},
                {4, 8, 9}};
        System.out.println(new Solution().kthSmallest(matrix, 4));
    }
}
