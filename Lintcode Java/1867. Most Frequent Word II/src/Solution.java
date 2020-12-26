import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * @param paragraph: a string
     * @return: the most frequent word
     */
    public String mostCommonWord(String paragraph) {
        // write your code here
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < paragraph.length(); i++) {
            if (!Character.isLetter(paragraph.charAt(i))) {
                continue;
            }
            
            int j = i;
            for (; j < paragraph.length() && Character.isLetter(paragraph.charAt(j)); j++) {
            
            }
            
            String sub = paragraph.substring(i, j).toLowerCase();
            map.put(sub, map.getOrDefault(sub, 0) + 1);
            
            i = j;
        }
        
        String res = "";
        int freq = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > freq) {
                freq = entry.getValue();
                res = entry.getKey();
            } else if (entry.getValue() == freq && entry.getKey().compareTo(res) < 0) {
                res = entry.getKey();
            }
        }
        
        return res;
    }
}
