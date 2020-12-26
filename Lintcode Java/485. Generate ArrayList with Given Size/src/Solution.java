import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param size: An integer
     * @return: An integer list
     */
    public List<Integer> generate(int size) {
        // write your code here
        List<Integer> res = new ArrayList<>();
    
        for (int i = 0; i < size; i++) {
            res.add(i + 1);
        }
        
        return res;
    }
}
