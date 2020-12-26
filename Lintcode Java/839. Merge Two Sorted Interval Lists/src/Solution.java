import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param list1: one of the given list
     * @param list2: another list
     * @return: the new sorted list of interval
     */
    public List<Interval> mergeTwoInterval(List<Interval> list1, List<Interval> list2) {
        // write your code here
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        
        int i = 0, j = 0;
        Interval cur = null;
        List<Interval> res = new ArrayList<>();
        while (i < list1.size() && j < list2.size()) {
            Interval i1 = list1.get(i), i2 = list2.get(j);
            if (i1.start <= i2.start) {
                cur = i1;
                i++;
            } else {
                cur = i2;
                j++;
            }
            
            if (res.isEmpty()) {
                res.add(cur);
            } else {
                merge(res, res.get(res.size() - 1), cur);
            }
        }
        
        while (j < list2.size()) {
            merge(res, res.get(res.size() - 1), list2.get(j++));
        }
        
        while (i < list1.size()) {
            merge(res, res.get(res.size() - 1), list1.get(i++));
        }
        
        return res;
    }
    
    private void merge(List<Interval> res, Interval last, Interval cur) {
        if (last.end < cur.start) {
            res.add(cur);
        } else {
            last.end = Math.max(last.end, cur.end);
        }
    }
    
    public static void main(String[] args) {
        List<Interval> list1 = new ArrayList<>();
        list1.add(new Interval(1, 2));
        list1.add(new Interval(3, 4));
        
        List<Interval> list2 = new ArrayList<>();
        list2.add(new Interval(4, 5));
        list2.add(new Interval(6, 7));
        
        List<Interval> intervals = new Solution().mergeTwoInterval(list1, list2);
        for (Interval interval : intervals) {
            System.out.println(interval.start + " " + interval.end);
        }
    }
}

class Interval {
    int start, end;
    
    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}