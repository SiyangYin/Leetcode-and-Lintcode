import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : deck) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
    
        int g = map.values().iterator().next();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            g = gcd(g, entry.getValue());
            if (g == 1) {
                return false;
            }
        }
        
        return true;
    }
    
    int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
    }
}
