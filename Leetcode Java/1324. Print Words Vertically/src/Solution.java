import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> printVertically(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.isEmpty()) {
            return res;
        }
    
        String[] strs = s.split(" ");
        int maxLen = 0;
        for (String str : strs) {
            maxLen = Math.max(maxLen, str.length());
        }
        
        for (int i = 0; i < maxLen; i++) {
            StringBuilder sb = new StringBuilder();
            for (String str : strs) {
                if (i < str.length()) {
                    sb.append(str.charAt(i));
                } else {
                    sb.append(' ');
                }
            }
            trimRight(sb);
            res.add(sb.toString());
        }
        
        return res;
    }
    
    private void trimRight(StringBuilder sb) {
        int i = sb.length() - 1;
        while (sb.charAt(i) == ' ') {
            i--;
        }
        
        sb.setLength(i + 1);
    }
}
