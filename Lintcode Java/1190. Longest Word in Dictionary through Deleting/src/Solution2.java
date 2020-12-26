import java.util.Arrays;
import java.util.List;

public class Solution2 {
    /**
     * @param s: a string
     * @param d: List[str]
     * @return: return a string
     */
    public String findLongestWord(String s, List<String> d) {
        // write your code  here
        String res = "";
    
        for (String str : d) {
            if (str.length() < res.length()) {
                continue;
            }
            if (str.length() == res.length() && res.compareTo(str) < 0) {
                continue;
            }
            
            if (check(s, str)) {
                res = str;
            }
        }
        
        return res;
    }
    
    private boolean check(String s, String d) {
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (j < d.length() && s.charAt(i) == d.charAt(j)) {
                j++;
            }
        }
        
        return j == d.length();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution2().findLongestWord("abpcplea", Arrays.asList("ale", "apple", "monkey", "plea")));
    }
}
