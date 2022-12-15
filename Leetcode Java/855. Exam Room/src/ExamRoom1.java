import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ExamRoom1 {
    private Set<Integer> set = new TreeSet<>();
    private int n;
    public ExamRoom1(int n) {
        this.n = n;
    }

    public int seat() {
        if (set.isEmpty()) {
            set.add(0);
            return 0;
        }
        else if (set.size() == 1) {
            int val = set.iterator().next();
            if (val >= n - 1 - val) {
                set.add(0);
                return 0;
            }
            else {
                set.add(n - 1);
                return n - 1;
            }
        }
        else {
            List<Integer> list = new ArrayList<>(set);
            int max;
            int res;
            if (list.get(0) != 0) {
                max = list.get(0);
                res = 0;
            }
            else {
                max = list.get(1) / 2;
                res = list.get(1) / 2;
            }
            for (int i = 1; i < list.size(); i++) {
                int diff = (list.get(i) - list.get(i - 1)) / 2;
                if (diff > max) {
                    max = diff;
                    res = (list.get(i) + list.get(i - 1)) / 2;
                }
            }
            if (list.get(list.size() - 1) != n - 1) {
                int diff = (n - 1 - list.get(list.size() - 1));
                if (diff > max) {
                    res = n - 1;
                }
            }
            set.add(res);
            return res;
        }
    }

    public void leave(int p) {
        set.remove(p);
    }
    
    public static void main(String[] args) {
        ExamRoom1 examRoom = new ExamRoom1(4);
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        examRoom.leave(1);
        examRoom.leave(3);
        System.out.println(examRoom.seat());
    }
}