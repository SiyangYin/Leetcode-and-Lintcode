public class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        
        if (s1.length() != s2.length()) {
            return false;
        }
        
        int[] count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length(); i++) {
            if (count[s2.charAt(i) - 'a'] == 0) {
                return false;
            }
            count[s2.charAt(i) - 'a']--;
        }
    
        int len = s1.length();
        for (int i = 1; i <= len - 1; i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i, len), s2.substring(i, len))) {
                return true;
            }
            if (isScramble(s1.substring(0, i), s2.substring(len - i, len)) && isScramble(s1.substring(i, len), s2.substring(0, len - i))) {
                return true;
            }
        }
        
        
        return false;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().isScramble("ab", "ba"));
        System.out.println(new Solution().isScramble("abcde", "caebd"));
        System.out.println(new Solution().isScramble("great", "rgeat"));
    }
}
