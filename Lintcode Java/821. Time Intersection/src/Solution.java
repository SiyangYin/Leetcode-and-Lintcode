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
     * @param seqA: the list of intervals
     * @param seqB: the list of intervals
     * @return: the time periods
     */
    public List<Interval> timeIntersection(List<Interval> seqA, List<Interval> seqB) {
        // Write your code here
        List<Interval> res = new ArrayList<>();
        List<Pair> list = new ArrayList<>();
        
        for (Interval interval : seqA) {
            list.add(new Pair(interval.start, 1));
            list.add(new Pair(interval.end, 0));
        }
        
        for (Interval interval : seqB) {
            list.add(new Pair(interval.start, 1));
            list.add(new Pair(interval.end, 0));
        }
        
        list.sort((i1, i2) -> i1.time != i2.time ? Integer.compare(i1.time, i2.time) : Integer.compare(i1.flag, i2.flag));
        
        int count = 0;
        boolean begin = false;
        for (int i = 0; i < list.size(); i++) {
            Pair cur = list.get(i);
            if (cur.flag == 1) {
                count++;
            } else {
                count--;
            }
            
            if (count == 2) {
                res.add(new Interval(cur.time, cur.time));
                begin = true;
            }
            if (count == 1 && begin) {
                res.get(res.size() - 1).end = cur.time;
                begin = false;
            }
            
        }
        return res;
    }
    
    public static void main(String[] args) {
        List<Interval> seqA = new ArrayList<>() {{
            add(new Interval(1, 2));
            add(new Interval(10, 15));
        }};
        List<Interval> seqB = new ArrayList<>() {{
            add(new Interval(3, 5));
            add(new Interval(7, 9));
        }};
    
        System.out.println(new Solution().timeIntersection(seqA, seqB));
    }
}

class Interval {
    int start, end;
    
    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
    
    @Override
    public String toString() {
        return "Interval{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}