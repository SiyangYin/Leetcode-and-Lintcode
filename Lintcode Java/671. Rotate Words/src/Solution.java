import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    /*
     * @param words: A list of words
     * @return: Return how many different rotate words
     */
    public int countRotateWords(List<String> words) {
        // Write your code here
        Set<String> set = new HashSet<>();
        
        for (String word : words) {
            String w = word + word;
            for (int i = 0; i + word.length() <= w.length(); i++) {
                set.remove(w.substring(i, i + word.length()));
            }
            
            set.add(word);
        }
        
        return set.size();
    }
}
