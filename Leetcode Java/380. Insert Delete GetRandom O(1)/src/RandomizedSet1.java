import java.util.*;

public class RandomizedSet1 {
    private Set<Integer> set;
    private List<Integer> list;
    public RandomizedSet1() {
        set = new HashSet<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        boolean res = !set.contains(val);
        if (res) {
            set.add(val);
            list.add(val);
        }
        return res;
    }

    public boolean remove(int val) {
        boolean res = set.contains(val);
        if(res) {
            set.remove(val);
            list.remove((Integer)val);
        }
        return res;
    }

    public int getRandom() {
        return list.get((int)(Math.random() * list.size()));
    }
}
