import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String s : cpdomains) {
            String[] split = s.split(" ");
            int time = Integer.parseInt(split[0]);
            map.put(split[1], map.getOrDefault(split[1], 0) + time);
            for (int i = 0; i < split[1].length(); i++) {
                if (split[1].charAt(i) == '.') {
                    String sub = split[1].substring(i + 1);
                    map.put(sub, map.getOrDefault(sub, 0) + time);
                }
            }
        }
    
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            res.add(entry.getValue() + " " + entry.getKey());
        }
        
        return res;
    }
}
