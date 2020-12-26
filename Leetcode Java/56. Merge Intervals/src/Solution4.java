import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Solution4 {
    class Point implements Comparable<Point> {
        int x;
        boolean isLeft;
        
        Point(int x, boolean isLeft) {
            this.x = x;
            this.isLeft = isLeft;
        }
        
        @Override
        public int compareTo(Point another) {
            if (this.x != another.x) {
                return this.x < another.x ? -1 : 1;
            }
            
            return this.isLeft ? -1 : 1;
        }
    }
    
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return intervals;
        }
        
        TreeSet<Point> set = new TreeSet<>();
        for (int[] interval : intervals) {
            set.add(new Point(interval[0], true));
            set.add(new Point(interval[1], false));
        }
        
        List<int[]> list = new ArrayList<>();
        int leftCount = 0, left = Integer.MAX_VALUE;
        for (Point point : set) {
            if (point.isLeft) {
                left = Math.min(left, point.x);
                leftCount++;
            } else {
                leftCount--;
                if (leftCount == 0) {
                    list.add(new int[]{left, point.x});
                    left = Integer.MAX_VALUE;
                }
            }
        }
        
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        
        return res;
    }
}
