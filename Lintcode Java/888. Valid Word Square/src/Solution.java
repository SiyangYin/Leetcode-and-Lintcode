public class Solution {
    /**
     * @param words: a list of string
     * @return: a boolean
     */
    public boolean validWordSquare(String[] words) {
        // Write your code here
        for (int i = 0; i < words[0].length(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < words.length; j++) {
                if (i < words[j].length()) {
                    sb.append(words[j].charAt(i));
                }
            }
            
            if (!sb.toString().equals(words[i])) {
                return false;
            }
        }
        
        return true;
    }
}
