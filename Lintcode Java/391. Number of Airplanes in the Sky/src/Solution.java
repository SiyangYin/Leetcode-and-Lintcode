import java.util.ArrayList;
import java.util.List;

public class Solution {
    
    class Pair {
        int time, flag;
        
        public Pair(int time, int flag) {
            this.time = time;
            this.flag = flag;
        }
    }
    
    /**
     * @param airplanes: An interval array
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes) {
        // write your code here
        List<Pair> list = new ArrayList<>();
        for (Interval interval : airplanes) {
            list.add(new Pair(interval.start, 1));
            list.add(new Pair(interval.end, 0));
        }
        
        list.sort((p1, p2) -> p1.time != p2.time ? Integer.compare(p1.time, p2.time) : Integer.compare(p1.flag, p2.flag));
        
        int res = 0, count = 0;
        for (Pair pair : list) {
            if (pair.flag == 1) {
                count++;
            } else {
                count--;
            }
            
            res = Math.max(res, count);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        List<Interval> airs = new ArrayList<>() {{
            add(new Interval(2, 10));
            add(new Interval(2, 10));
            add(new Interval(2, 10));
        }};
        System.out.println(new Solution().countOfAirplanes(airs));
    }
}

class Interval {
    int start, end;
    
    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}