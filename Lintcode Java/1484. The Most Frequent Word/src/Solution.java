import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution {
    /**
     * @param s:            a string
     * @param excludewords: a dict
     * @return: the most frequent word
     */
    public String frequentWord(String s, Set<String> excludewords) {
        // Write your code here
        String res = "";
        Map<String, Integer> map = new HashMap<>();
        String[] strs = s.split(" ");
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            if (!Character.isLetter(str.charAt(str.length() - 1))) {
                str = str.substring(0, str.length() - 1);
            }
            
            if (!excludewords.contains(str)) {
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
        }
    
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (res.isEmpty()) {
                res = entry.getKey();
                maxCount = entry.getValue();
                continue;
            }
            
            if (entry.getValue() > maxCount) {
                res = entry.getKey();
                maxCount = entry.getValue();
            } else if (entry.getValue() == maxCount) {
                if (entry.getKey().compareTo(res) < 0) {
                    res = entry.getKey();
                }
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println("i".compareTo("have"));
    }
}
