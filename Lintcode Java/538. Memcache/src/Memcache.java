import java.util.HashMap;
import java.util.Map;

public class Memcache {
    
    class Pair {
        int val, expTime;
    
        public Pair(int val, int expTime) {
            this.val = val;
            this.expTime = expTime;
        }
    }
    
    private Map<Integer, Pair> map;
    
    public Memcache() {
        // do intialization if necessary
        map = new HashMap<>();
    }
    
    /*
     * @param curtTime: An integer
     * @param key: An integer
     * @return: An integer
     */
    public int get(int curtTime, int key) {
        // write your code here
        Pair pair = map.get(key);
        if (pair == null || curtTime > pair.expTime) {
            return Integer.MAX_VALUE;
        }
        
        return pair.val;
    }
    
    /*
     * @param curtTime: An integer
     * @param key: An integer
     * @param value: An integer
     * @param ttl: An integer
     * @return: nothing
     */
    public void set(int curtTime, int key, int value, int ttl) {
        // write your code here
        map.put(key, new Pair(value, ttl == 0 ? Integer.MAX_VALUE : curtTime + ttl - 1));
    }
    
    /*
     * @param curtTime: An integer
     * @param key: An integer
     * @return: nothing
     */
    public void delete(int curtTime, int key) {
        // write your code here
        map.remove(key);
    }
    
    /*
     * @param curtTime: An integer
     * @param key: An integer
     * @param delta: An integer
     * @return: An integer
     */
    public int incr(int curtTime, int key, int delta) {
        // write your code here
        Pair pair = map.get(key);
        if (!map.containsKey(key) || curtTime > pair.expTime) {
            return Integer.MAX_VALUE;
        }
    
        map.put(key, new Pair(pair.val + delta, pair.expTime));
        return pair.val + delta;
    }
    
    /*
     * @param curtTime: An integer
     * @param key: An integer
     * @param delta: An integer
     * @return: An integer
     */
    public int decr(int curtTime, int key, int delta) {
        // write your code here
        Pair pair = map.get(key);
        if (!map.containsKey(key) || curtTime > pair.expTime) {
            return Integer.MAX_VALUE;
        }
    
        map.put(key, new Pair(pair.val - delta, pair.expTime));
        return pair.val - delta;
    }
    
    public static void main(String[] args) {
        Memcache mem = new Memcache();
        System.out.println(mem.get(1, 0));
        mem.set(2, 1, 1, 2);
        System.out.println(mem.get(3, 1));
        System.out.println(mem.get(4, 1));
        System.out.println(mem.incr(5, 1, 1));
        mem.set(6, 1, 3, 0);
        System.out.println(mem.incr(7, 1, 1));
    }
}