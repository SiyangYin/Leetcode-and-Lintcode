public class Solution {
    /**
     * @param s: a string
     * @return: a string
     */
    public String largestLetter(String s) {
        // write your code here
        boolean[] existA = new boolean[26], exista = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if ('a' <= ch && ch <= 'z') {
                exista[ch - 'a'] = true;
            } else if ('A' <= ch && ch <= 'Z') {
                existA[ch - 'A'] = true;
            }
        }
        
        char res = 0;
        for (int i = 25; i >= 0; i--) {
            if (existA[i] && exista[i]) {
                res = (char) ('A' + i);
                break;
            }
        }
        
        return res == 0 ? "NO" : String.valueOf(res);
    }
}
