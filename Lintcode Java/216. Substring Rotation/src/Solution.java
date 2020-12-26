public class Solution {
    /**
     * @param s1: the first string
     * @param s2: the socond string
     * @return: true if s2 is a rotation of s1 or false
     */
    public boolean isRotation(String s1, String s2) {
        // write your code here
        if (s2 == null || s2.isEmpty()) {
            return false;
        }
        
        if (s2.length() != s1.length()) {
            return false;
        }
        
        return isSubstring(s2, s1 + s1);
    }
    
    private boolean isSubstring(String s2, String  s1) {
        return s1.contains(s2);
    }
}
