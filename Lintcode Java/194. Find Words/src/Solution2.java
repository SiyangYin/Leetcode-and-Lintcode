import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
    /**
     * @param str:  the string
     * @param dict: the dictionary
     * @return: return words which  are subsequences of the string
     */
    public List<String> findWords(String str, List<String> dict) {
        // Write your code here.
        List<String> res = new ArrayList<>();
        int[][] auto = new int[str.length() + 1][26];
    
        for (int[] row : auto) {
            Arrays.fill(row, -1);
        }
        
        for (int i = str.length() - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                auto[i][j] = auto[i + 1][j];
            }
            
            auto[i][str.charAt(i) - 'a'] = i + 1;
        }
        
        for (String s : dict) {
            int idx = 0;
            for (int i = 0; i < s.length() && idx != -1; i++) {
                idx = auto[idx][s.charAt(i) - 'a'];
            }
            
            if (idx != -1) {
                res.add(s);
            }
        }
    
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution2().findWords("abcde", Arrays.asList("bb")));
    }
}
