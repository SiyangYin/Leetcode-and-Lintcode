import java.util.*;

public class Solution2 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        Map<Integer, String> map1 = new TreeMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for(String word : words) {
            set.add(word);
            map2.put(word, map2.getOrDefault(word, 0) + 1);
        }
        for (String word : set) {
            isSubStr(s, word, map1);
        }
        List<Integer> list = new ArrayList<>(map1.keySet());
        int i = 0, j = 0;
        while(j < list.size()) {
            if(j > 0 && list.get(j) - list.get(j - 1) > words[0].length()) {
                i = j;
            }
            while (i <= j && list.get(j) - list.get(i) >= (words.length - 1) * words[0].length()) {
                Map<String, Integer> map3 = new HashMap<>();
                for (int k = list.get(i); k <= list.get(j); k += words[0].length()) {
                    map3.put(map1.get(k), map3.getOrDefault(map1.get(k), 0) + 1);
                }
                if (map2.equals(map3)) {
                    res.add(list.get(i));
                }
                i++;
            }
            j++;
        }
        return res;
    }

    public void isSubStr(String s, String p, Map<Integer, String> map) {
        if (p.length() > s.length()) {
            return;
        }
        int P = 131;
        int pow = 1;
        int hashS = 0, hashP = 0;
        for (int i = 0; i < p.length(); i++) {
            hashS = hashS * P + s.charAt(i);
            hashP = hashP * P + p.charAt(i);
            pow *= P;
        }
        if (hashS == hashP) {
            map.put(0, p);
        }
        for (int i = p.length(); i < s.length(); i++) {
            hashS = hashS * P - pow * s.charAt(i - p.length()) + s.charAt(i);
            if(hashS == hashP) {
                map.put(i - p.length() + 1, p);
            }
        }
        return;
    }
}
