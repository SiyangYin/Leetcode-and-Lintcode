import java.util.*;

public class Solution {
    /**
     * @param s: The string s
     * @param excludeList: The excludeList
     * @return: Return the most frequent words
     */
    public String[] getWords(String s, String[] excludeList) {
        // Write your code here
        Set<String> set = new HashSet<>();
        for (String str : excludeList) {
            set.add(str.toLowerCase());
        }
        
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                int j = i;
                while (j < s.length() && Character.isLetter(s.charAt(j))) {
                    j++;
                }
    
                String sub = s.substring(i, j).toLowerCase();
                if (!set.contains(sub)) {
                    map.put(sub, map.getOrDefault(sub, 0) + 1);
                }
                
                i = j - 1;
            }
        }
        
        List<String> list = new ArrayList<>();
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                list.clear();
                list.add(entry.getKey());
            } else if (entry.getValue() == maxCount) {
                list.add(entry.getKey());
            }
        }
        
        String[] res = new String[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        
        Arrays.sort(res);
        return res;
    }
}
