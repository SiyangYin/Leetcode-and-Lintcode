import java.util.*;

public class RandomizedCollection {
    
    private List<Integer> list;
    private Map<Integer, Set<Integer>> map;
    private Random random;
    
    /**
     * Initialize your data structure here.
     */
    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }
    
    /**
     * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {
        boolean res = false;
        if (!map.containsKey(val) || map.get(val).isEmpty()) {
            res = true;
        }
        
        list.add(val);
        map.putIfAbsent(val, new HashSet<>());
        map.get(val).add(list.size() - 1);
        
        return res;
    }
    
    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val) || map.get(val).isEmpty()) {
            return false;
        }
    
        Set<Integer> set = map.get(val);
        if (val == list.get(list.size() - 1)) {
            set.remove(list.size() - 1);
            list.remove(list.size() - 1);
        } else {
            int pos = set.iterator().next();
            set.remove(pos);
    
            int last = list.get(list.size() - 1);
            map.get(last).remove(list.size() - 1);
            map.get(last).add(pos);
            Collections.swap(list, pos, list.size() - 1);
            list.remove(list.size() - 1);
        }
        return true;
    }
    
    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
    
    public static void main(String[] args) {
        RandomizedCollection ran = new RandomizedCollection();
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
