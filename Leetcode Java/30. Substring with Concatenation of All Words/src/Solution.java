import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (words.length == 0) {
            return res;
        }
        
        Map<String, Integer> tot = new HashMap<>();
        for (String word : words) {
            tot.put(word, tot.getOrDefault(word, 0) + 1);
        }
        
        int w = words[0].length(), n = words.length;
        for (int i = 0; i < w; i++) {
            Map<String, Integer> cnt = new HashMap<>();
            int count = 0;
            for (int j = i; j + w <= s.length(); j += w) {
                if (j >= i + w * n) {
                    String sub = s.substring(j - n * w, j - (n - 1) * w);
                    if (tot.containsKey(sub) && cnt.get(sub) <= tot.get(sub)) {
                        count--;
                    }
                    cnt.put(sub, cnt.get(sub) - 1);
                }
                
                String sub = s.substring(j, j + w);
                cnt.put(sub, cnt.getOrDefault(sub, 0) + 1);
                if (tot.containsKey(sub) && cnt.get(sub) <= tot.get(sub)) {
                    count++;
                }
                
                if (count == n) {
                    res.add(j - (n - 1) * w);
                }
            }
        }
        
        return res;
    }
}
