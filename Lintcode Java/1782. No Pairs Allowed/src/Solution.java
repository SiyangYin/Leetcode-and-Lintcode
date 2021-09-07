import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param words: The array words that you need to calculate minimal operation .
     * @return: Return an array of integers, each result[i] being the minimum operations needed to fix words[i].
     */
    public List<Integer> minimalOperation (List<String> words) {
        // Write your code here.
        List<Integer> res = new ArrayList<>();
        for (String s : words) {
            int cnt = 0;
            for (int i = 0; i < s.length(); i++) {
                int j = i;
                while (j < s.length() && s.charAt(j) == s.charAt(i)) {
                    j++;
                }
                
                cnt += j - i >> 1;
                i = j - 1;
            }
            
            res.add(cnt);
        }
        
        return res;
    }
}
