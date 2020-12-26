import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }
        
        int odd = 0;
        char oddChar = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count.length; i++) {
            if (count[i] % 2 == 1) {
                odd++;
                oddChar = (char) i;
            }
            
            sb.append(String.valueOf((char) i).repeat(count[i] / 2));
        }
        
        if (odd >= 2) {
            return res;
        }
        
        boolean hasOdd = false;
        if (odd == 1) {
            hasOdd = true;
        }
        
        dfs(new StringBuilder(), sb.toString(), new boolean[sb.length()], hasOdd, oddChar, res);
        
        return res;
    }
    
    private void dfs(StringBuilder sb, String s, boolean[] used, boolean hasOdd, char oddChar, List<String> res) {
        if (sb.length() == s.length()) {
            if (hasOdd) {
                res.add(sb.toString() + oddChar + sb.reverse().toString());
            } else {
                res.add(sb.toString() + sb.reverse().toString());
            }
            sb.reverse();
            return;
        }
        
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && s.charAt(i) == s.charAt(i - 1) && !used[i - 1]) {
                continue;
            }
            
            if (used[i]) {
                continue;
            }
            
            sb.append(s.charAt(i));
            used[i] = true;
            dfs(sb, s, used, hasOdd, oddChar, res);
            sb.setLength(sb.length() - 1);
            used[i] = false;
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().generatePalindromes("aabb"));
        
        StringBuilder sb = new StringBuilder("abc");
        sb.reverse();
        System.out.println(sb);
    }
}
