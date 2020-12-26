import java.util.*;

public class RandomizedSet {
    
    private List<Integer> list;
    private Map<Integer, Integer> map;
    private Random random;
    
    public RandomizedSet() {
        // do intialization if necessary
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }
    
    /*
     * @param val: a value to the set
     * @return: true if the set did not already contain the specified element or false
     */
    public boolean insert(int val) {
        // write your code here
        if (map.containsKey(val)) {
            return false;
        }
        
        map.put(val, list.size());
        list.add(val);
        return true;
    }
    
    /*
     * @param val: a value from the set
     * @return: true if the set contained the specified element or false
     */
    public boolean remove(int val) {
        // write your code here
        if (!map.containsKey(val)) {
            return false;
        }
        
        int idx = map.get(val);
        if (idx != list.size() - 1) {
            Collections.swap(list, idx, list.size() - 1);
        }
        
        map.put(list.get(idx), idx);
        list.remove(list.size() - 1);
        return true;
    }
    
    /*
     * @return: Get a random element from the set
     */
    public int getRandom() {
        // write your code here
        int ranIdx = random.nextInt(list.size());
        return list.get(ranIdx);
    }
}
