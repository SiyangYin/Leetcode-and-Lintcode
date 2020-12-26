public class Solution {
    /**
     * @param word: a string
     * @return: return a boolean
     */
    public boolean detectCapitalUse(String word) {
        // write your code here
        if (word.isEmpty()) {
            return true;
        }
        
        boolean hasUpper = false, hasLower = false;
        for (int i = 0; i < word.length(); i++) {
            if (Character.isLowerCase(word.charAt(i))) {
                hasLower = true;
            } else {
                hasUpper = true;
            }
        }
        
        if (!hasLower || !hasUpper) {
            return true;
        }
        
        if (!Character.isUpperCase(word.charAt(0))) {
            return false;
        }
        
        for (int i = 1; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                return false;
            }
        }
        
        return true;
    }
}
