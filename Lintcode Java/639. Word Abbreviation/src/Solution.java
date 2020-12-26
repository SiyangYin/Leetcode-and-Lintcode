import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * @param dict: an array of n distinct non-empty strings
     * @return: an array of minimal possible abbreviations for every word
     */
    public String[] wordsAbbreviation(String[] dict) {
        // write your code here
        int len = dict.length;
        String[] res = new String[len];
        Map<String, Integer> map = new HashMap<>();
        int[] pref = new int[len];
        
        for (int i = 0; i < len; i++) {
            pref[i] = 1;
            res[i] = getAbbr(dict[i], 1);
            map.put(res[i], map.getOrDefault(res[i], 0) + 1);
        }
        
        boolean unique = false;
        while (!unique) {
            unique = true;
            for (int i = 0; i < len; i++) {
                if (map.get(res[i]) > 1) {
                    pref[i]++;
                    res[i] = getAbbr(dict[i], pref[i]);
                    map.put(res[i], map.getOrDefault(res[i], 0) + 1);
                    unique = false;
                }
            }
        }
        
        return res;
    }
    
    private String getAbbr(String s, int i) {
        if (i >= s.length() - 2) {
            return s;
        }
        
        return s.substring(0, i) + (s.length() - i - 1) + s.charAt(s.length() - 1);
    }
    
    // public static void main(String[] args) {
    //     System.out.println(Arrays.toString(new Solution().wordsAbbreviation(new String[]{"like", "god", "internal", "me", "internet", "interval", "intension", "face", "intrusion"})));
    // }
}
