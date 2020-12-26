import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param target: the target string
     * @param s:
     * @return: output all strings containing target  in s
     */
    public String[] getAns(String target, String[] s) {
        // Write your code here
        List<String> list = new ArrayList<>();
    
        for (String str : s) {
            if (check(str, target)) {
                list.add(str);
            }
        }
        
        String[] res = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        
        return res;
    }
    
    private boolean check(String s, String t) {
        for (int i = 0, j = 0; i < s.length() && j < t.length(); i++) {
            if (s.charAt(i) == t.charAt(j)) {
                j++;
            }
            
            if (j == t.length()) {
                return true;
            }
        }
        
        return false;
    }
}
