import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    /**
     * @param nums: a integer array
     * @return: return an integer denoting the number of non-unique(duplicate) values
     */
    public List<Integer> CountDuplicates(List<Integer> nums) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                if (map.get(num) == 1) {
                    res.add(num);
                }
                
                map.put(num, map.get(num) + 1);
            }
        }
        
        return res;
    }
}
