import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class MyCalendarThree {
    
    private TreeMap<Integer, Integer> map;
    
    public MyCalendarThree() {
        map = new TreeMap<>();
    }
    
    public int book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        
        int res = 0, sum = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            sum += entry.getValue();
            res = Math.max(res, sum);
        }
        
        return res;
    }
}