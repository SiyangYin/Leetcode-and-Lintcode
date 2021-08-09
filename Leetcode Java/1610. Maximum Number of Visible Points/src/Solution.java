import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        int cnt = 0;
        double x = location.get(0), y = location.get(1);
        List<Double> list = new ArrayList<>();
        for (List<Integer> point : points) {
            if (point.equals(location)) {
                cnt++;
                continue;
            }
            
            double x1 = point.get(0), y1 = point.get(1);
            double acos = Math.acos((x1 - x) / Math.sqrt(pow2(x1 - x) + pow2(y1 - y)));
            if (y1 < y) {
                acos = 2 * Math.PI - acos;
            }
            list.add(acos);
        }
        
        double ang = angle / 180.0 * Math.PI;
        list.sort(Double::compare);
        int size = list.size();
        for (int i = size; i < size * 2; i++) {
            list.add(list.get(i - size) + 2 * Math.PI);
        }
        
        int res = cnt;
        for (int i = 0, j = 0; i < list.size(); i++) {
            while (j < list.size() && list.get(j) - list.get(i) <= ang) {
                j++;
            }
            
            res = Math.max(res, cnt + j - i);
        }
        
        return res;
    }
    
    double pow2(double x) {
        return x * x;
    }
    
    public static void main(String[] args) {
        List<List<Integer>> points = new ArrayList<>();
        points.add(Arrays.asList(1, 0));
        points.add(Arrays.asList(2, 1));
        int ang = 13;
        List<Integer> loc = Arrays.asList(1, 1);
        
        System.out.println(new Solution().visiblePoints(points, ang, loc));
    }
}
