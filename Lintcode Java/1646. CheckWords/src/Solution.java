import java.util.HashSet;
import java.util.Set;

public class Solution {
    /**
     * @param s:
     * @param str:
     * @return: Output whether this combination meets the condition
     */
    public boolean checkWord(String s, String[] str) {
        // Write your code here
        Set<String> set = new HashSet<>();
        for (String string : str) {
            set.add(string);
        }
        
        if (set.size() < s.length()) {
            return false;
        }
        
        return dfs(s, set, new HashSet<>());
    }
    
    private boolean dfs(String cur, Set<String> set, Set<String> visited) {
        visited.add(cur);
        if (!set.contains(cur)) {
            return false;
        }
    
        if (cur.length() == 1 && set.contains(cur)) {
            return true;
        }
        
        for (int i = 0; i < cur.length(); i++) {
            String next = cur.substring(0, i) + cur.substring(i + 1);
            if (!visited.contains(next) && dfs(next, set, visited)) {
                return true;
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().checkWord("abc", new String[]{"abc", "ac", "c"}));
    }
}
