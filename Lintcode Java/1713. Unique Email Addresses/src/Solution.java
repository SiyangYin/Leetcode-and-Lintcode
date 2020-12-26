import java.util.HashSet;
import java.util.Set;

public class Solution {
    /**
     * @param emails:
     * @return: The number of the different email addresses
     */
    public int numUniqueEmails(String[] emails) {
        // write your code here
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (String email : emails) {
            sb.setLength(0);
            int atIdx = 0;
            for (int i = 0; i < email.length(); i++) {
                char ch = email.charAt(i);
                if (ch == '@') {
                    atIdx = i;
                    break;
                }
            }
    
            for (int i = 0; i < email.length(); i++) {
                char ch = email.charAt(i);
                if (i < atIdx) {
                    if (ch == '+') {
                        i = atIdx - 1;
                    } else {
                        sb.append(ch == '.' ? "" : ch);
                    }
                } else {
                    sb.append(ch);
                }
            }
            
            set.add(sb.toString());
        }
        
        return set.size();
    }
}
