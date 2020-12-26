import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            int at = email.indexOf('@');
            String host = email.substring(at);
            StringBuilder name = new StringBuilder();
            for (int i = 0; i < at; i++) {
                char ch = email.charAt(i);
                if (ch == '+') {
                    break;
                }
                if (ch != '.') {
                    name.append(ch);
                }
            }
            
            set.add(name.append(host).toString());
        }
        
        return set.size();
    }
    
    public static void main(String[] args) {
        String[] em = {"test.email+alex@leetcode.com", "test.email@leetcode.com"};
        System.out.println(new Solution().numUniqueEmails(em));
    }
}
