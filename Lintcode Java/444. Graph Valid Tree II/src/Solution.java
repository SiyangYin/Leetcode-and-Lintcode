import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    
    List<Integer> p;
    Map<Integer, Integer> map;
    int idx, group;
    boolean isValid;
    
    public Solution() {
        p = new ArrayList<>();
        map = new HashMap<>();
        isValid = true;
    }
    
    int find(int x) {
        if (x != p.get(x)) {
            p.set(x, find(p.get(x)));
        }
        
        return p.get(x);
    }
    
    void union(int x, int y) {
        int px = find(x), py = find(y);
        if (px == py) {
            isValid = false;
            return;
        }
        
        p.set(px, py);
        group--;
    }
    
    /**
     * @param a: the node a
     * @param b: the node b
     * @return: nothing
     */
    public void addEdge(int a, int b) {
        // write your code here
        if (!map.containsKey(a)) {
            group++;
            p.add(idx);
            map.put(a, idx++);
        }
        if (!map.containsKey(b)) {
            group++;
            p.add(idx);
            map.put(b, idx++);
        }
        
        int x = map.get(a), y = map.get(b);
        union(x, y);
    }
    
    /**
     * @return: check whether these edges make up a valid tree
     */
    public boolean isValidTree() {
        // write your code here
        return isValid && group == 1;
    }
}
