public class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0;
        while (i < word.length() && j < abbr.length()) {
            if (word.charAt(i) == abbr.charAt(j)) {
                i++;
                j++;
            } else {
                if (Character.isLetter(abbr.charAt(j))) {
                    return false;
                }
                
                if (abbr.charAt(j) == '0') {
                    return false;
                }
                
                int k = j;
                while (k < abbr.length() && Character.isDigit(abbr.charAt(k))) {
                    k++;
                }
                
                int skip = Integer.parseInt(abbr.substring(j, k));
                j = k;
                i += skip;
            }
        }
        
        return i == word.length() && j == abbr.length();
    }
}
