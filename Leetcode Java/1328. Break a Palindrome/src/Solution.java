public class Solution {
    public String breakPalindrome(String palindrome) {
        char[] s = palindrome.toCharArray();
        for (int i = 0; i < s.length / 2; i++) {
            if (s[i] != 'a') {
                s[i] = 'a';
                return new String(s);
            }
        }
        
        s[s.length - 1] = 'b';
        return s.length == 1 ? "" : new String(s);
    }
}
