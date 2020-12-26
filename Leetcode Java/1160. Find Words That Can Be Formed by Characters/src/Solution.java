import java.util.Arrays;

public class Solution {
    public int countCharacters(String[] words, String chars) {
        int res = 0;
        
        int[] chs = new int[26];
        for (int i = 0; i < chars.length(); i++) {
            chs[chars.charAt(i) - 'a']++;
        }
        
        int[] word = new int[26];
        boolean isValid = true;
        for (int i = 0; i < words.length; i++) {
            isValid = true;
            Arrays.fill(word, 0);
            for (int j = 0; j < words[i].length(); j++) {
                char letter = words[i].charAt(j);
                word[letter - 'a']++;
                if (word[letter - 'a'] > chs[letter - 'a']) {
                    isValid = false;
                    break;
                }
            }
            
            if (isValid) {
                res += words[i].length();
            }
        }
        
        return res;
    }
}
