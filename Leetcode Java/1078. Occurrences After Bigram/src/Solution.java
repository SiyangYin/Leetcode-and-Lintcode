import java.util.ArrayList;
import java.util.List;

class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        List<String> list = new ArrayList<>();
    
        String[] strs = text.split(" ");
        for (int i = 0; i < strs.length - 1; i++) {
            if (strs[i].equals(first) && strs[i + 1].equals(second)) {
                if (i + 2 < strs.length) {
                    list.add(strs[i + 2]);
                }
            }
        }
    
        String[] res = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        
        return res;
    }
}

