import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> res = new ArrayList<>();
        
        List<int[]> list = new ArrayList<>();
        for (List<Interval> intervals : schedule) {
            for (Interval interval : intervals) {
                list.add(new int[]{interval.start, 0});
                list.add(new int[]{interval.end, 1});
            }
        }
        
        list.sort((p1, p2) -> p1[0] != p2[0] ? Integer.compare(p1[0], p2[0]) : Integer.compare(p1[1], p2[1]));
        int count = 0;
        boolean begin = false;
        for (int[] pair : list) {
            if (pair[1] == 0) {
                count++;
            } else {
                count--;
            }
            
            if (count == 0) {
                res.add(new Interval(pair[0], pair[0]));
                begin = true;
            } else if (begin) {
                res.get(res.size() - 1).end = pair[0];
                begin = false;
            }
        }
        
        res.remove(res.size() - 1);
        return res;
    }
}

class Interval {
    public int start;
    public int end;
    
    public Interval() {
    }
    
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