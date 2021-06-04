import java.util.*;

public class Solution {
    /**
     * @param s: a string
     * @return: return List[str]
     */
    public List<String> findRepeatedDnaSequences(String s) {
        // write your code here
        List<String> res = new ArrayList<>();
        if (s.length() < 10) {
            return res;
        }
        
        Map<Long, Integer> map = new HashMap<>();
        long hash = 0, P = 131, pow = 1;
        for (int i = 0; i < 10; i++) {
            hash = hash * P + s.charAt(i);
            pow *= P;
        }
        map.put(hash, 0);
        
        Set<Integer> set = new HashSet<>();
        for (int i = 10; i < s.length(); i++) {
            hash = hash * P + s.charAt(i);
            hash -= s.charAt(i - 10) * pow;
            if (map.containsKey(hash)) {
                set.add(map.get(hash));
            } else {
                map.put(hash, i - 9);
            }
        }
    
        for (int idx : set) {
            res.add(s.substring(idx, idx + 10));
        }
        
        return res;
    }
}
