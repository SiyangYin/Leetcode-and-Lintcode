import java.util.*;

class RandomizedCollection {
    
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
        // write your code here
        boolean res = false;
        if (!map.containsKey(val) || map.get(val).isEmpty()) {
            map.put(val, new HashSet<>());
            res = true;
        }
        
        map.get(val).add(list.size());
        list.add(val);
        
        return res;
    }
    
    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {
        // write your code here
        if (!map.containsKey(val) || map.get(val).isEmpty()) {
            return false;
        }
        
        Set<Integer> set = map.get(val);
        if (val == list.get(list.size() - 1)) {
            set.remove(list.size() - 1);
            list.remove(list.size() - 1);
            return true;
        }
        
        int pos = set.iterator().next();
        int last = list.get(list.size() - 1);
        map.get(last).remove(list.size() - 1);
        map.get(last).add(pos);
        
        set.remove(pos);
        
        Collections.swap(list, pos, list.size() - 1);
        list.remove(list.size() - 1);
        return true;
    }
    
    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
        // write your code here
        int r = random.nextInt(list.size());
        return list.get(r);
    }
    
    public static void main(String[] args) {
        RandomizedCollection ran = new RandomizedCollection();
        ran.insert(4);
        ran.insert(3);
        ran.insert(4);
        ran.insert(2);
        ran.insert(4);
        
        ran.remove(4);
        ran.remove(3);
        ran.remove(4);
        ran.remove(4);
    }
}