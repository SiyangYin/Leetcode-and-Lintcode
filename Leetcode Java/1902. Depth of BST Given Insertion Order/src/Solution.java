import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public int maxDepthBST(int[] order) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int res = 0;
        for (int x : order) {
            if (map.isEmpty()) {
                map.put(x, 0);
            } else {
                Map.Entry<Integer, Integer> floor = map.floorEntry(x), ceil = map.ceilingEntry(x);
                int depth = 0;
                if (floor != null) {
                    depth = Math.max(depth, floor.getValue());
                }
                if (ceil != null) {
                    depth = Math.max(depth, ceil.getValue());
                }
                map.put(x, depth + 1);
            }
            
            res = Math.max(res, map.get(x));
        }
        
        return res;
    }
}
