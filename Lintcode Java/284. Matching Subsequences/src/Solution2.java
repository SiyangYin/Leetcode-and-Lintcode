import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
    /**
     * @param source: A string
     * @param words: A list of string
     * @return: return list of words[i] that is a subsequence of source.
     */
    public List<String> MatchingSubsequences(String source, List<String> words) {
        // write your code here
        List<String> res = new ArrayList<>();
        int[][] auto = new int[source.length() + 1][128];
        for (int[] row : auto) {
            Arrays.fill(row, -1);
        }
    
        for (int i = source.length() - 1; i >= 0; i--) {
            for (int j = 0; j < 128; j++) {
                auto[i][j] = auto[i + 1][j];
            }
            
            auto[i][source.charAt(i)] = i + 1;
        }
    
        for (String word : words) {
            int idx = 0;
            for (int i = 0; i < word.length() && idx != -1; i++) {
                idx = auto[idx][word.charAt(i)];
            }
            
            if (idx != -1) {
                res.add(word);
            }
        }
        
        return res;
    }
}
