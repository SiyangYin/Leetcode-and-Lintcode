import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param heights: Students height
     * @return: How many people are not where they should be
     */
    public int orderCheck(List<Integer> heights) {
        // write your code here
        List<Integer> sorted = new ArrayList<>(heights);
        sorted.sort(Integer::compareTo);
        
        int res = 0;
        for (int i = 0; i < heights.size(); i++) {
            if (!heights.get(i).equals(sorted.get(i))) {
                res++;
            }
        }
        
        return res;
    }
}
