import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> map1 = new HashMap<>(), map2 = new HashMap<>();
        for (String s : words1) {
            map1.put(s, map1.getOrDefault(s, 0) + 1);
        }
        for (String s : words2) {
            map2.put(s, map2.getOrDefault(s, 0) + 1);
        }
    
        int res = 0;
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            String s = entry.getKey();
            int cnt = entry.getValue();
            if (cnt == 1 && map2.getOrDefault(s, 0) == 1) {
                res++;
            }
        }
        
        return res;
    }
}
