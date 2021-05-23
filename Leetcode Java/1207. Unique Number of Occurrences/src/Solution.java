import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : arr) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        
        Set<Integer> set = new HashSet<>();
        for (int x : map.values()) {
            if (!set.add(x)) {
                return false;
            }
        }
        
        return true;
    }
}
