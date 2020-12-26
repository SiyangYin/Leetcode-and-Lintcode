import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Solution2 {
    
    class Pair {
        int x, y;
        Interval interval;
        
        public Pair(int x, int y, Interval interval) {
            this.x = x;
            this.y = y;
            this.interval = interval;
        }
    }
    
    /**
     * @param intervals: the given k sorted interval lists
     * @return: the new sorted interval list
     */
    public List<Interval> mergeKSortedIntervalLists(List<List<Interval>> intervals) {
        // write your code here
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((i1, i2) -> Integer.compare(i1.interval.start, i2.interval.start));
        for (int i = 0; i < intervals.size(); i++) {
            if (!intervals.get(i).isEmpty()) {
                minHeap.offer(new Pair(i, 0, intervals.get(i).get(0)));
            }
        }
        
        List<Interval> res = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            Pair cur = minHeap.poll();
            extend(res, cur.interval);
            if (cur.y + 1 < intervals.get(cur.x).size()) {
                minHeap.offer(new Pair(cur.x, cur.y + 1, intervals.get(cur.x).get(cur.y + 1)));
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
        System.out.println(new Solution2().mergeKSortedIntervalLists(lists));
    }
}
