import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    /**
     * @param cpdomains: a list cpdomains of count-paired domains
     * @return: a list of count-paired domains
     */
    public List<String> subdomainVisits(String[] cpdomains) {
        // Write your code here
        Map<String, Integer> map = new HashMap<>();
        for (String cpdomain : cpdomains) {
            String[] sp = cpdomain.split(" ");
            int count = Integer.parseInt(sp[0]);
    
            String domain = sp[1];
            map.put(domain, map.getOrDefault(domain, 0) + count);
    
            for (int i = 0; i < domain.length(); i++) {
                if (domain.charAt(i) == '.') {
                    String sub = domain.substring(i + 1);
                    map.put(sub, map.getOrDefault(sub, 0) + count);
                }
            }
        }
        
        List<String> res = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            res.add(String.valueOf(entry.getValue()) + ' ' + entry.getKey());
        }
        
        return res;
    }
}
