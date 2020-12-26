public class Solution {
    /**
     * @param s: The string s
     * @param t: The string t
     * @return: Return if can get the string t
     */
    public boolean canGetString(String s, String t) {
        // Write your code here
        int idx1 = 0, idx2 = 0;
        while (idx1 < s.length() && idx2 < t.length()) {
            if (s.charAt(idx1) == t.charAt(idx2)) {
                idx2++;
            }
            
            idx1++;
        }
        
        return idx2 == t.length();
    }
}
