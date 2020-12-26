import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    /**
     * @param wage: Salaries of all employees
     * @param ask: Number of inquiries
     * @return: Every time an answer is asked
     */
    public List<Integer> PeopleCounting(List<Integer> wage, List<Integer> ask) {
        // write your code here
        Map<Integer, Integer> map = new HashMap<>();
        for (int w : wage) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
        
        List<Integer> res = new ArrayList<>();
        for (int a : ask) {
            res.add(map.getOrDefault(a, 0));
        }
        
        return res;
    }
}
