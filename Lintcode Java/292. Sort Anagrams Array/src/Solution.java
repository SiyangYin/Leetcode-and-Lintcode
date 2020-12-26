import java.util.*;

public class Solution {
    /**
     * @param str: a string array
     * @return: return a sorted string array
     */
    public String[] SortAnagramsArray(String[] str) {
        // write your code here
        Map<String, List<String>> map = new TreeMap<>();
        for (String s : str) {
            String sorted = sortStr(s);
            map.putIfAbsent(sorted, new ArrayList<>());
            map.get(sorted).add(s);
        }
    
        int idx = 0;
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            for (String s : entry.getValue()) {
                str[idx++] = s;
            }
        }
        
        return str;
    }
    
    private String sortStr(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                sb.append((char) ('a' + i));
            }
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().sortStr("ppale"));
        System.out.println(Arrays.toString(new Solution().SortAnagramsArray(new String[]{"ppale", "lintcode", "google", "apple"})));
    }
}
