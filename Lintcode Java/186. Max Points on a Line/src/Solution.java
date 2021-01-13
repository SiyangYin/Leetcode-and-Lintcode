import java.util.Arrays;

public class Solution {
    /**
     * @param points: an array of point
     * @return: An integer
     */
    public int maxPoints(Point[] points) {
        // write your code here
        if (points == null || points.length == 0) {
            return 0;
        }
        
        Arrays.sort(points, (p1, p2) -> p1.x != p2.x ? Integer.compare(p1.x, p2.x) : Integer.compare(p1.y, p2.y));
        
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            int duplicate = 1;
            Point p1 = points[i];
            if (i > 0 && equals(p1, points[i - 1])) {
                continue;
            }
            
            for (int j = i + 1; j < points.length; j++) {
                Point p2 = points[j];
                if (equals(p1, p2)) {
                    duplicate++;
                    continue;
                }
                
                int count = 0;
                for (int k = j + 1; k < points.length; k++) {
                    Point p3 = points[k];
                    if ((p1.x * p2.y - p1.y * p2.x) - (p1.x * p3.y - p1.y * p3.x) + (p2.x * p3.y - p2.y * p3.x) == 0) {
                        count++;
                    }
                }
                
                res = Math.max(res, duplicate + count + 1);
            }
            
            res = Math.max(res, duplicate);
        }
        
        return res;
    }
    
    private boolean equals(Point p1, Point p2) {
        return p1.x == p2.x && p1.y == p2.y;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().maxPoints(
                new Point[]{new Point(1, 2),
                        new Point(3, 6),
                        new Point(0, 0),
                        new Point(1, 3)}));
        
    }
}

class Point {
    int x, y;
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}