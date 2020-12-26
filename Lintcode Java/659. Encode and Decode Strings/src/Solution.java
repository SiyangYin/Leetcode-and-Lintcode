import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /*
     * @param strs: a list of strings
     * @return: encodes a list of strings to a single string.
     */
    public String encode(List<String> strs) {
        // write your code here
        StringBuilder sb = new StringBuilder();
        
        for (String str : strs) {
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (ch == ':') {
                    sb.append("::");
                } else {
                    sb.append(ch);
                }
            }
            
            sb.append(":;");
        }
        
        return sb.toString();
    }
    
    /*
     * @param str: A string
     * @return: dcodes a single string to a list of strings
     */
    public List<String> decode(String str) {
        // write your code here
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == ':') {
                if (str.charAt(i + 1) == ';') {
                    res.add(sb.toString());
                    sb.setLength(0);
                    
                    i++;
                } else {
                    sb.append(str.charAt(i + 1));
                    
                    i++;
                }
            } else {
                sb.append(ch);
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        Solution so = new Solution();
        System.out.println(so.encode(Arrays.asList("C#", "&", "~Xp|F", "R4QBf9g=_")));
    }
}
