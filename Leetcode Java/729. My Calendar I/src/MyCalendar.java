import java.util.TreeMap;

public class MyCalendar {
    
    private TreeMap<Integer, Integer> map;
    
    public MyCalendar() {
        map = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        Integer prev = map.floorKey(start), next = map.ceilingKey(start);
        if ((prev == null || map.get(prev) <= start) && (next == null || end <= next)) {
            map.put(start, next);
            return true;
        }
        
        return false;
    }
}