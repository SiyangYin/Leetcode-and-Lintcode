import java.util.*;

public class RandomizedSet2 {
    private Map<Integer, Integer> map;
    private List<Integer> list;
    public RandomizedSet2() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        boolean res = !map.containsKey(val);
        if (res) {
            map.put(val, list.size());
            list.add(val);
        }
        return res;
    }

    public boolean remove(int val) {
        boolean res = map.containsKey(val);
        if(res) {
            int i = map.get(val);
            Collections.swap(list, i, list.size() - 1);
            map.put(list.get(i), i);
            map.remove(val);
            list.remove(list.size() - 1);
        }
        return res;
    }

    public int getRandom() {
        return list.get((int)(Math.random() * list.size()));
    }
}
