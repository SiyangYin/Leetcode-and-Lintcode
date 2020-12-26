import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    /**
     * @param p: the point List
     * @return: the numbers of pairs which meet the requirements
     */
    public int pairNumbers(Point[] p) {
        // Write your code here
        Map<Integer, List<Point>> map = new HashMap<>();
        for (int i = 0; i < 4; i++) {
            map.put(i, new ArrayList<>());
        }
        
        for (Point point : p) {
            int b1 = point.x % 2, b2 = point.y % 2;
            map.get((b1 << 1) + b2).add(point);
        }
        
        int res = 0;
        for (int i = 0; i < 4; i++) {
            int size = map.get(i).size();
            res += size * (size - 1) / 2;
        }
        
        return res;
    }
}

class Point {
    int x, y;
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}