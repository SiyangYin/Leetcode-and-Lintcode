import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    /**
     * @param emails: Original email
     * @return: Return the count of groups which has more than one email address in it.
     */
    public int countGroups(List<String> emails) {
        // Write your code here
        Map<String, Integer> map = new HashMap<>();
        
        StringBuilder sb = new StringBuilder();
        for (String email : emails) {
            sb.setLength(0);
    
            int idx = 0;
            for (int i = 0; i < email.length(); i++) {
                char ch = email.charAt(i);
                if (ch == '@') {
                    idx = i;
                    break;
                }
            }
    
            for (int i = 0; i < email.length(); i++) {
                char ch = email.charAt(i);
                if (i < idx && ch == '+') {
                    i = idx - 1;
                    continue;
                }
                
                if (i < idx) {
                    sb.append(ch == '.' ? "" : ch);
                } else {
                    sb.append(ch);
                }
            }
    
            String s = sb.toString();
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        
        int res = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                res++;
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().countGroups(Arrays.asList("abc.bc+c+d@jiuzhang.com", "abcbc+d@jiuzhang.com", "abc.bc.cd@jiuzhang.com")));
    }
}
