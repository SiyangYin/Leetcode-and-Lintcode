import java.util.*;

public class Solution {
    /**
     * @param str: the string that needs to be sorted
     * @return: sorted string
     */
    public String stringSort(String str) {
        // Write your code here
        Map<Character, Integer> map = new HashMap<>();
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            list.add(c);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        list.sort((o1, o2) -> {
            int c1 = map.get(o1), c2 = map.get(o2);
            return c1 == c2 ? Character.compare(o1, o2) : -Integer.compare(c1, c2);
        });
    
        StringBuilder sb = new StringBuilder();
        for (Character ch : list) {
            sb.append(ch);
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().stringSort("bloomberg"));
    }
}
