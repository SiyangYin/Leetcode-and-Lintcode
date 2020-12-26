import java.util.HashSet;
import java.util.Set;

public class Solution {
    /**
     * @param words: the given list of words
     * @return: the number of different transformations among all words we have
     */
    public int uniqueMorseRepresentations(String[] words) {
        // Write your code here
        String[] codes = {".-", "-...", "-.-.",
                "-..", ".", "..-.",
                "--.", "....", "..",
                ".---", "-.-", ".-..",
                "--", "-.", "---",
                ".--.", "--.-", ".-.",
                "...", "-", "..-",
                "...-", ".--",
                "-..-", "-.--", "--.."};
    
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            sb.setLength(0);
            for (int j = 0; j < word.length(); j++) {
                sb.append(codes[word.charAt(j) - 'a']);
            }
            set.add(sb.toString());
        }
        
        return set.size();
    }
}
