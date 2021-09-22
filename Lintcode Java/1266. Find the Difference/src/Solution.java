public class Solution {
    /**
     * @param s: a string
     * @param t: a string
     * @return: the letter that was added in t
     */
    public char findTheDifference(String s, String t) {
        // Write your code here
        char res = 0;
        for (int i = 0; i < s.length(); i++) {
            res ^= s.charAt(i) ^ t.charAt(i);
        }
        
        return (char) (res ^ t.charAt(s.length()));
    }
}
