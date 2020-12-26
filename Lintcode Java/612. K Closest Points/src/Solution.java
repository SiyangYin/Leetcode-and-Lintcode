import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    /**
     * @param points: a list of points
     * @param origin: a point
     * @param k: An integer
     * @return: the k closest points
     */
    public Point[] kClosest(Point[] points, Point origin, int k) {
        // write your code here
        PriorityQueue<Point> maxHeap = new PriorityQueue<>((p1, p2) -> {
            int d1 = sqDis(p1, origin), d2 = sqDis(p2, origin);
            if (d1 == d2) {
                return p1.y == p2.y ? -Integer.compare(p1.y, p2.y) : -Integer.compare(p1.x, p2.x);
            } else {
                return -Integer.compare(d1, d2);
            }
        });
        
        for (Point point : points) {
            if (maxHeap.size() < k) {
                maxHeap.offer(point);
            } else {
                Point top = maxHeap.peek();
                int d1 = sqDis(point, origin), d2 = sqDis(top, origin);
                if (d1 < d2 || (d1 == d2 && point.x < top.x) || (d1 == d2 && point.x == top.x && point.y < top.y)) {
                    maxHeap.poll();
                    maxHeap.offer(point);
                }
            }
        }
        
        Point[] res = new Point[maxHeap.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = maxHeap.poll();
        }
        
        return res;
    }
    
    private int sqDis(Point p1, Point p2) {
        return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
    }
    
    public static void main(String[] args) {
        Point[] ps = {
                new Point(4,6),
                new Point(4,7),
                new Point(4,4),
                new Point(2,5),
                new Point(1,1),
        };
        Point ori = new Point(0,0);
        System.out.println(Arrays.toString(new Solution().kClosest(ps, ori, 3)));
    }
}

class Point {
    int x, y;
    
    public Point() {
    }
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}