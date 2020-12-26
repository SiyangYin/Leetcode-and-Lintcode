public class Solution {
    public String modifyString(String s) {
        char[] str = s.toCharArray();
        for (int i = 0; i < str.length; i++) {
            if (str[i] == '?') {
                str[i] = helper(str, i);
            }
        }
        
        return new String(str);
    }
    
    private char helper(char[] s, int pos) {
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (pos > 0 && ch == s[pos - 1]) {
                continue;
            }
            
            if (pos < s.length - 1 && ch == s[pos + 1]) {
                continue;
            }
            
            return ch;
        }
        
        return 0;
    }
}
