import java.util.*;

public class RandomizedCollection1 {
    private Map<Integer, Set<Integer>> map;
    private List<Integer> list;
    public RandomizedCollection1() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        boolean res = !map.containsKey(val);
        Set<Integer> set = map.getOrDefault(val, new HashSet<>());
        set.add(list.size());
        map.putIfAbsent(val, set);
        list.add(val);
        return res;
    }

    public boolean remove(int val) {
        boolean res = map.containsKey(val);
        Set<Integer> s1 = map.getOrDefault(val, new HashSet<>());
        if (s1.size() > 0) {
            int i = s1.iterator().next();
            Collections.swap(list, i, list.size() - 1);
            s1.remove(i);
            Set<Integer> s2 = map.get(list.get(i));
            s2.add(i);
            s2.remove(list.size() - 1);
            list.remove(list.size() - 1);
        }
        if (s1.size() == 0) {
            map.remove(val);
        }
        return res;
    }

    public int getRandom() {
        return list.get((int)(Math.random() * list.size()));
    }
    
    public static void main(String[] args) {
        RandomizedCollection1 ran = new RandomizedCollection1();
        ran.insert(0);
        ran.remove(0);
        ran.insert(-1);
        ran.remove(0);
        
        System.out.println(ran.getRandom());
        System.out.println(ran.getRandom());
        System.out.println(ran.getRandom());
        System.out.println(ran.getRandom());
    }
}
