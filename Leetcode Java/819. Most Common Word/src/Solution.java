import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String res = "";
        int maxLen = 0;
        Map<String, Integer> map = new HashMap<>();
        int i = 0;
        while (i < paragraph.length()) {
            while (i < paragraph.length() && !Character.isLetter(paragraph.charAt(i))) {
                i++;
            }
            
            if (i == paragraph.length()) {
                break;
            }
            
            int j = i + 1;
            while (j < paragraph.length() && Character.isLetter(paragraph.charAt(j))) {
                j++;
            }
            String cur = paragraph.substring(i, j).toLowerCase();
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            i = j;
        }
        
        Set<String> set = new HashSet<>();
        for (String s : banned) {
            set.add(s);
        }
        
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (!set.contains(entry.getKey()) && entry.getValue() > maxLen) {
                res = entry.getKey();
                maxLen = entry.getValue();
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        String para = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] ban = {"hit"};
        System.out.println(new Solution().mostCommonWord(para, ban));
    }
}
