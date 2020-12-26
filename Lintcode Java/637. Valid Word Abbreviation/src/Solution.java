public class Solution {
    /**
     * @param word: a non-empty string
     * @param abbr: an abbreviation
     * @return: true if string matches with the given abbr or false
     */
    public boolean validWordAbbreviation(String word, String abbr) {
        // write your code here
        int i = 0, j = 0;
        while (i < word.length() && j < abbr.length()) {
            if (word.charAt(i) == abbr.charAt(j)) {
                i++;
                j++;
            } else if (Character.isLetter(abbr.charAt(j))) {
                return false;
            } else {
                if (abbr.charAt(j) == '0') {
                    return false;
                }
                
                int k = j;
                while (k < abbr.length() && Character.isDigit(abbr.charAt(k))) {
                    k++;
                }
                
                int skip = Integer.parseInt(abbr.substring(j, k));
                i += skip;
                j = k;
            }
        }
        
        return i == word.length() && j == abbr.length();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().validWordAbbreviation("internationalization", "i12iz4n"));
        System.out.println(new Solution().validWordAbbreviation("apple", "a3e"));
        System.out.println(new Solution().validWordAbbreviation("aa", "a2"));
        System.out.println(new Solution().validWordAbbreviation("hi", "hi1"));
    }
}
