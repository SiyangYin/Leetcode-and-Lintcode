import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public boolean isReflected(int[][] points) {
        if (points.length == 0) {
            return true;
        }
        
        int minX = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE;
        for (int[] point : points) {
            minX = Math.min(minX, point[0]);
            maxX = Math.max(maxX, point[0]);
        }
        
        int sumX = minX + maxX;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] point : points) {
            map.putIfAbsent(point[1], new ArrayList<>());
            map.get(point[1]).add(point[0]);
        }
        
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> list = entry.getValue();
            list.sort(null);
            for (int i = 0, j = list.size() - 1; i <= j; i++, j--) {
                while (i + 1 < list.size() && list.get(i) == list.get(i + 1)) {
                    i++;
                }
                
                while (j > 0 && list.get(j) == list.get(j - 1)) {
                    j--;
                }
                
                if (list.get(i) + list.get(j) != sumX) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
