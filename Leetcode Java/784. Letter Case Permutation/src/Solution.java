import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        dfs(S.toCharArray(), 0, res);
        return res;
    }
    
    private void dfs(char[] s, int pos, List<String> res) {
        res.add(new String(s));
        
        for (int i = pos; i < s.length; i++) {
            if (!Character.isLetter(s[i])) {
                continue;
            }
            
            char ch = s[i];
            if (Character.isUpperCase(ch)) {
                s[i] = Character.toLowerCase(ch);
                dfs(s, i + 1, res);
                s[i] = ch;
            } else {
                s[i] = Character.toUpperCase(ch);
                dfs(s, i + 1, res);
                s[i] = ch;
            }
        }
    }
    
    public static void main(String[] args) {
        List<String> list = new Solution().letterCasePermutation("a1b");
        System.out.println(new HashSet<>(list).size());
        System.out.println(list);
        System.out.println(list.size());
    }
}
