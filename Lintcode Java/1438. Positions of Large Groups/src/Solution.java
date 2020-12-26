import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * @param S: a string
     * @return: the starting and ending positions of every large group
     */
    public List<List<Integer>> largeGroupPositions(String S) {
        // Write your code here
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            int j = i;
            while (j < S.length() && S.charAt(j) == S.charAt(i)) {
                j++;
            }
            
            if (j - i >= 3) {
                res.add(Arrays.asList(i, j - 1));
            }
            
            i = j - 1;
        }
        
        return res;
    }
}
