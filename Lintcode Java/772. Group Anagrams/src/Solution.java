import java.util.*;

public class Solution {
    /**
     * @param strs: the given array of strings
     * @return: The anagrams which have been divided into groups
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        // write your code here
        List<List<String>> res = new ArrayList<>();
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
            res.add(entry.getValue());
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        char[] a = {'1', '2', '3'};
    }
}
