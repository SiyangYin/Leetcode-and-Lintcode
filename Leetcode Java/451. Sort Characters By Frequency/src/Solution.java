import java.util.*;

public class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        List<Character> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (c1, c2) -> map.get(c1) > map.get(c2) ? -1 : 1);
        StringBuilder sb = new StringBuilder();
        for (char c : list) {
            for (int i = 0; i < map.get(c); i++) {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().frequencySort("tree"));
    }
}
