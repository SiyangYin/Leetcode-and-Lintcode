import java.util.*;

public class Solution {
    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public List<String> anagrams(String[] strs) {
        // write your code here
        List<String> res = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return res;
        }
    
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] s = strs[i].toCharArray();
            Arrays.sort(s);
            String key = new String(s);
            
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(strs[i]);
        }
    
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getValue().size() > 1) {
                res.addAll(entry.getValue());
            }
        }
        
        return res;
    }
}
