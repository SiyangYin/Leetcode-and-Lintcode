import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    
    class Pair {
        int time, flag;
    
        public Pair(int time, int flag) {
            this.time = time;
            this.flag = flag;
        }
    }
    
    /**
     * @param logs: Sequence of processes
     * @param queries: Sequence of queries
     * @return: Return the number of processes
     */
    public List<Integer> numberOfProcesses(List<Interval> logs, List<Integer> queries) {
        // Write your code here
        List<Integer> res = new ArrayList<>();
        List<Pair> list = new ArrayList<>();
    
        for (Interval log : logs) {
            list.add(new Pair(log.start, 0));
            list.add(new Pair(log.end, 1));
        }
    
        for (Integer query : queries) {
            list.add(new Pair(query, 2));
        }
        
        list.sort((p1, p2) -> {
            if (p1.time != p2.time) {
                return Integer.compare(p1.time, p2.time);
            }
            
            return Integer.compare(p1.flag, p2.flag);
        });
    
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            Pair cur = list.get(i);
            if (cur.flag == 0) {
                count++;
            } else if (cur.flag == 1) {
                count--;
            }
            
            if (cur.flag == 2) {
                map.put(cur.time, count);
            }
        }
    
        for (int query : queries) {
            res.add(map.get(query));
        }
        
        return res;
    }
}

class Interval {
    int start, end;
    
    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}