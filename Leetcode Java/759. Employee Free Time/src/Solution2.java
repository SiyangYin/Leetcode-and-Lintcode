import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Solution2 {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> res = new ArrayList<>();
        
        Map<Integer, Integer> map = new TreeMap<>();
        for (List<Interval> intervals : schedule) {
            for (Interval interval : intervals) {
                map.put(interval.start, map.getOrDefault(interval.start, 0) + 1);
                map.put(interval.end, map.getOrDefault(interval.end, 0) - 1);
            }
        }
    
        int count = 0;
        boolean begin = false;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 0) {
                continue;
            }
            
            int time = entry.getKey();
            count += entry.getValue();
            if (count == 0) {
                res.add(new Interval(time, time));
                begin = true;
            } else if (begin) {
                res.get(res.size() - 1).end = time;
                begin = false;
            }
        }
        
        res.remove(res.size() - 1);
        return res;
    }
    
    public static void main(String[] args) {
        List<List<Interval>> sch = new ArrayList<>();
        sch.add(new ArrayList<>(){{
            add(new Interval(1,3));
            add(new Interval(6,7));
        }});
        sch.add(new ArrayList<>(){{
            add(new Interval(2,4));
            add(new Interval(2,5));
            add(new Interval(9,12));
        }});
    
        System.out.println(new Solution2().employeeFreeTime(sch));
    }
}
