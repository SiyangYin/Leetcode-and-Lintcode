import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Solution2 {
    public class Solution {
        /**
         * @param airplanes: An interval array
         * @return: Count of airplanes are in the sky.
         */
        public int countOfAirplanes(List<Interval> airplanes) {
            // write your code here
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (Interval in : airplanes) {
                map.put(in.start, map.getOrDefault(in.start, 0) + 1);
                map.put(in.end, map.getOrDefault(in.end, 0) - 1);
            }
    
            int res = 0, count = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                count += entry.getValue();
                res = Math.max(res, count);
            }
            
            return res;
        }
    }
}
