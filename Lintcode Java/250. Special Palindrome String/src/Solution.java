import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * @param ambigram: A list of paired ambigram letter.
     * @param word: A string need to be judged.
     * @return: If it is special palindrome string, return true.
     */
    public boolean ispalindrome(List<String> ambigram, String word) {
        // write your code here.
        boolean[][] change = new boolean[26][26];
        for (String s : ambigram) {
            int first = s.charAt(0) - 'a', second = s.charAt(1) - 'a';
            change[first][second] = change[second][first] = true;
        }
        
        for (int i = 0, j = word.length() - 1; i < j; i++, j--) {
            char l = word.charAt(i), r = word.charAt(j);
            if (l == r || change[l - 'a'][r - 'a'] || change[r - 'a'][l - 'a']) {
                continue;
            }
    
            boolean check = false;
            for (int k = 0; k < 26; k++) {
                boolean lchangeToK = false, rchangeToK = false;
                lchangeToK = change[l - 'a'][k] || change[k][l - 'a'];
                rchangeToK = change[r - 'a'][k] || change[k][r - 'a'];
                if (lchangeToK && rchangeToK) {
                    check = true;
                    break;
                }
            }
            
            if (check) {
                continue;
            }
            
            return false;
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        List<String> list = Arrays.asList("at", "by", "yh", "hn", "mw", "ww");
        System.out.println(new Solution().ispalindrome(list, "swims"));
    }
}
