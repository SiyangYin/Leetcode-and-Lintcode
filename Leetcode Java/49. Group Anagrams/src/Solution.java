import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
    
        Map<String, List<String>> map = new HashMap<>();
    
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String cur = new String(chars);
            map.putIfAbsent(cur, new ArrayList<>());
            map.get(cur).add(s);
        }
    
        for (List<String> list : map.values()) {
            res.add(list);
        }
        
        return res;
    }
}
