public class Solution {
    public boolean checkIfPangram(String sentence) {
        boolean[] exists = new boolean[26];
        for (int i = 0; i < sentence.length(); i++) {
            exists[sentence.charAt(i) - 'a'] = true;
        }
    
        for (boolean exist : exists) {
            if (!exist) {
                return false;
            }
        }
        
        return true;
    }
}
