import java.util.*;

public class MyCalendar1 {
    private Set<Integer> set1;
    private Set<Integer> set2;
    public MyCalendar1() {
        set1 = new TreeSet<>();
        set2 = new TreeSet<>();
    }

    public boolean book(int start, int end) {
        if (set1.isEmpty()) {
            set1.add(start);
            set2.add(end);
            return true;
        }
        else {
            List<Integer> list1 = new ArrayList<>(set1);
            List<Integer> list2 = new ArrayList<>(set2);
            int l = 0, r = list1.size() - 1;
            while (l < r) {
                int m = l + r >> 1;
                if (list2.get(m) < end) {
                    l = m + 1;
                }
                else {
                    r = m;
                }
            }
            if (list1.get(r) >= end && (r == 0 || list2.get(r - 1) <= start) || list2.get(r) <= start && (r >= list1.size() - 1 || list1.get(r + 1) >= end)) {
                set1.add(start);
                set2.add(end);
                return true;
            }
            else {
                return false;
            }
        }
    }
}