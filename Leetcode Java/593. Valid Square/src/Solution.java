import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] ps = {p1, p2, p3, p4};
        Map<Integer, Integer> map = new HashMap<>();
        int mind = Integer.MAX_VALUE, maxd = 0;
        for (int i = 0; i < ps.length; i++) {
            for (int j = i + 1; j < ps.length; j++) {
                int d = dis(ps[i], ps[j]);
                mind = Math.min(mind, d);
                maxd = Math.max(maxd, d);
                map.put(d, map.getOrDefault(d, 0) + 1);
            }
        }
        
        return map.size() == 2 && maxd == 2 * mind && map.get(maxd) * 2 == map.get(mind);
    }
    
    private int dis(int[] p1, int[] p2) {
        int d1 = p1[0] - p2[0], d2 = p1[1] - p2[1];
        return d1 * d1 + d2 * d2;
    }
}
