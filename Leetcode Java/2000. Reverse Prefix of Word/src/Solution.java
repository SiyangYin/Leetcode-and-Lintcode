public class Solution {
    public String reversePrefix(String word, char ch) {
        char[] s = word.toCharArray();
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ch) {
                for (int j = 0; j < i; j++, i--) {
                    char tmp = s[j];
                    s[j] = s[i];
                    s[i] = tmp;
                }
                
                return new String(s);
            }
        }
        
        return word;
    }
}
