import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Solution2 {
    
    private TreeSet<Interval> set = new TreeSet<>((i1, i2) -> Integer.compare(i1.start, i2.start));
    
    {
        set.add(new Interval(Integer.MIN_VALUE, Integer.MIN_VALUE));
        set.add(new Interval(Integer.MAX_VALUE, Integer.MAX_VALUE));
    }
    
    /**
     * @param val: An integer.
     * @return: nothing
     */
    public void addNum(int val) {
        // write your code here
        Interval interval = new Interval(val, val);
        Interval floor = set.floor(interval), ceiling = set.ceiling(interval);
        if (floor.end < val - 1 && ceiling.start > val + 1) {
            set.add(interval);
            return;
        }
        
        if (ceiling.start == val + 1 && floor.end < val - 1) {
            set.remove(ceiling);
            ceiling.start = val;
            set.add(ceiling);
            return;
        }
        if (floor.end == val - 1 && ceiling.start > val + 1) {
            set.remove(floor);
            floor.end = val;
            set.add(floor);
            return;
        }
        
        set.remove(floor);
        set.remove(ceiling);
        ceiling.start = floor.start;
        set.add(ceiling);
    }
    
    /**
     * @return: A list of intervals.
     */
    public List<Interval> getIntervals() {
        // write your code here
        return new ArrayList<>(set).subList(1, set.size() - 1);
    }
    
    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        sol.addNum(1);
        sol.addNum(3);
        sol.addNum(7);
        
        System.out.println(sol.getIntervals());
        sol.addNum(2);
        System.out.println(sol.getIntervals());
        sol.addNum(6);
        System.out.println(sol.getIntervals());
    }
}

