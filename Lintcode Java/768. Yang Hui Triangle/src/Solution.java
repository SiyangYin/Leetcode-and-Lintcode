import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * @param n: a Integer
     * @return: the first n-line Yang Hui's triangle
     */
    public List<List<Integer>> calcYangHuisTriangle(int n) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        
        res.add(new ArrayList<>(Arrays.asList(1)));
    
        for (int i = 1; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    List<Integer> prev = res.get(i - 1);
                    row.add(prev.get(j - 1) + prev.get(j));
                }
            }
            res.add(row);
        }
        
        return res;
    }
}
