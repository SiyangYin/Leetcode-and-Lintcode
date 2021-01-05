import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    /**
     * @param tagList: The tag list.
     * @param allTags: All the tags.
     * @return: Return the answer
     */
    public int getMinimumStringArray(String[] tagList, String[] allTags) {
        // Write your code here
        int res = Integer.MAX_VALUE;
        Set<String> set = new HashSet<>();
        for (String s : tagList) {
            set.add(s);
        }
        
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; i < allTags.length; i++) {
            if (set.contains(allTags[i])) {
                map.put(allTags[i], map.getOrDefault(allTags[i], 0) + 1);
            }
            
            while (map.keySet().containsAll(set)) {
                res = Math.min(res, i - j + 1);
                if (set.contains(allTags[j])) {
                    map.put(allTags[j], map.get(allTags[j]) - 1);
                    
                    if (map.get(allTags[j]) == 0) {
                        map.remove(allTags[j]);
                    }
                }
                
                j++;
            }
        }
        
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
