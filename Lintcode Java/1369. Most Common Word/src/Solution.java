import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    /**
     * @param paragraph:
     * @param banned:
     * @return: nothing
     */
    public String mostCommonWord(String paragraph, String[] banned) {
        // write your code here
        Set<String> set = new HashSet<>();
        for (String s : banned) {
            set.add(s.toLowerCase());
        }
    
        Map<String, Integer> map = new HashMap<>();
        String[] ss = paragraph.split(" ");
        for (String s : ss) {
            if (!Character.isLetter(s.charAt(s.length() - 1))) {
                s = s.substring(0, s.length() - 1);
            }
            
            s = s.toLowerCase();
            if (!set.contains(s)) {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }
        
        int maxOcc = 0;
        String res = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxOcc) {
                maxOcc = entry.getValue();
                res = entry.getKey();
            }
        }
        
        return res;
    }
}
