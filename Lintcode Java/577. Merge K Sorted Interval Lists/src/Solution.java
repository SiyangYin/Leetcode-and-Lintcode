import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * @param intervals: the given k sorted interval lists
     * @return:  the new sorted interval list
     */
    public List<Interval> mergeKSortedIntervalLists(List<List<Interval>> intervals) {
        // write your code here
        return mergeSort(intervals, 0, intervals.size() - 1);
    }
    
    private List<Interval> mergeSort(List<List<Interval>> intervals, int l, int r) {
        if (l > r) {
            return new ArrayList<>();
        }
        if (l == r) {
            return intervals.get(l);
        }
    
        int mid = l + (r - l >> 1);
        List<Interval> left = mergeSort(intervals, l, mid), right = mergeSort(intervals, mid + 1, r);
        
        List<Interval> res = new ArrayList<>();
        for (int i = 0, j = 0; i < left.size() || j < right.size(); ) {
            if (i == left.size()) {
                extend(res, right.get(j++));
            } else if (j == right.size()) {
                extend(res, left.get(i++));
            } else {
                Interval i1 = left.get(i), i2 = right.get(j);
                if (i1.start <= i2.start) {
                    extend(res, i1);
                    i++;
                } else {
                    extend(res, i2);
                    j++;
                }
            }
        }
        
        return res;
    }
    
    private void extend(List<Interval> list, Interval interval) {
        if (list.isEmpty()) {
            list.add(interval);
            return;
        }
    
        Interval last = list.get(list.size() - 1);
        if (interval.start > last.end) {
            list.add(interval);
        } else {
            last.end = Math.max(last.end, interval.end);
        }
    }
    
    public static void main(String[] args) {
        List<List<Interval>> lists = new ArrayList<>();
        lists.add(Arrays.asList(new Interval(1, 3), new Interval(4, 7), new Interval(6, 8)));
        lists.add(Arrays.asList(new Interval(1, 2), new Interval(9, 10)));
        System.out.println(new Solution().mergeKSortedIntervalLists(lists));
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