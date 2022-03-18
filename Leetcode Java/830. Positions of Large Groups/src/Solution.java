import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            int j = i;
            while (j < s.length() && s.charAt(i) == s.charAt(j)) {
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
