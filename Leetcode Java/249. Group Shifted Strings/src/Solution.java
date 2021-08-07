import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            char[] chs = strings[i].toCharArray();
            if (chs[0] != 'a') {
                int diff = chs[0] - 'a';
                for (int j = 0; j < chs.length; j++) {
                    chs[j] -= diff;
                    if (chs[j] < 'a') {
                        chs[j] += 26;
                    }
                }
            }
    
            String s = new String(chs);
            map.putIfAbsent(s, new ArrayList<>());
            map.get(s).add(strings[i]);
        }
    
        return new ArrayList<>(map.values());
    }
}
