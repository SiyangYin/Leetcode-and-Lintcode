public class Solution {
    public boolean detectCapitalUse(String word) {
        if (word == null || word.isEmpty() || word.length() == 1) {
            return true;
        }
        
        char ch = word.charAt(0);
        int count = 0;
        for (int i = 1; i < word.length(); i++) {
            if (Character.isLowerCase(word.charAt(i))) {
                count++;
            }
        }
        
        if (count == word.length() - 1) {
            return true;
        }
        
        if (Character.isUpperCase(ch) && count == 0) {
            return true;
        }
        
        return false;
    }
}
