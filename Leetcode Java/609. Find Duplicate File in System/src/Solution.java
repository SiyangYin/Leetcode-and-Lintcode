import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String path : paths) {
            String[] sp = path.split(" ");
            for (int i = 1; i < sp.length; i++) {
                String s = sp[i];
                int pos = s.lastIndexOf('(');
                String cont = s.substring(pos + 1, s.length() - 1), file = sp[0] + '/' + s.substring(0, pos);
                map.putIfAbsent(cont, new ArrayList<>());
                map.get(cont).add(file);
            }
        }
    
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getValue().size() > 1) {
                res.add(entry.getValue());
            }
        }
        
        return res;
    }
}
