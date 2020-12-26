import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return list;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            if (!map.containsKey(p.charAt(i))) {
                map.put(p.charAt(i), 1);
            } else {
                map.put(p.charAt(i), map.get(p.charAt(i)) + 1);
            }
        }
        Map<Character, Integer> maptmp = new HashMap<>(map);
        for (int i = 0; i < s.length() - p.length() + 1; i++) {
            if (checkAnagram(s, i, maptmp, p.length())) {
                list.add(i);
                while (i + p.length() < s.length() && s.charAt(i) == s.charAt(i + p.length())) {
                    i++;
                    list.add(i);
                }
            }
            maptmp = new HashMap<>(map);
        }
        return list;
    }
    
    private boolean checkAnagram(String s, int start, Map<Character, Integer> map, int lenOfP) {
        for (int i = start; i < start + lenOfP; i++) {
            if (!map.containsKey(s.charAt(i)) || map.get(s.charAt(i)) == 0) {
                return false;
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
//        System.out.println(new Solution().findAnagrams("cbaebabacd", "abc"));
        System.out.println(new Solution().findAnagrams("abab", "ab"));
    }
}
