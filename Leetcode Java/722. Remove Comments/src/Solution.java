import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> removeComments(String[] source) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        for (String s : source) {
            sb.append(s).append('\n');
        }
        String s = sb.toString();
        sb.setLength(0);
        for (int i = 0; i < s.length(); ) {
            if (i + 1 < s.length() && s.startsWith("//", i)) {
                while (s.charAt(i) != '\n') {
                    i++;
                }
            } else if (i + 1 < s.length() && s.startsWith("/*", i)) {
                i += 2;
                while (!s.startsWith("*/", i)) {
                    i++;
                }
                i += 2;
            } else if (s.charAt(i) == '\n') {
                if (sb.length() > 0) {
                    res.add(sb.toString());
                    sb.setLength(0);
                }
                
                i++;
            } else {
                sb.append(s.charAt(i++));
            }
        }
        
        return res;
    }
}
