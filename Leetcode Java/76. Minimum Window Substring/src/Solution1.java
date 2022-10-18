import java.util.HashMap;
import java.util.Map;

public class Solution1 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0) + 1);
        }
        int i = 0, j = 0;
        int min = Integer.MAX_VALUE;
        String res = "";
        while (i < s.length() || j < s.length()) {
            boolean covered = checkCover(mapS, mapT);
            if (!covered && j < s.length()) {
                if (mapT.containsKey(s.charAt(j))) {
                    mapS.put(s.charAt(j), mapS.getOrDefault(s.charAt(j), 0) + 1);
                }
                j++;
            }
            else if (covered && i < s.length()) {
                if (j - i < min) {
                    min = j - i;
                    res = s.substring(i, j);
                }
                if (mapT.containsKey(s.charAt(i))) {
                    mapS.put(s.charAt(i), mapS.getOrDefault(s.charAt(i), 0) - 1);
                }
                i++;
            }
            else {
                i++;
            }
        }
        return res;
    }

    public boolean checkCover(Map<Character, Integer> mapS, Map<Character, Integer> mapT) {
        for (char c : mapT.keySet()) {
            if (!mapS.containsKey(c) || mapS.get(c) < mapT.get(c)) return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution1().minWindow("ADOBECODEBANC", "ABC"));
    }
}
