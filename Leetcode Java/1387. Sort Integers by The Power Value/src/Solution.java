import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

public class Solution {
    public int getKth(int lo, int hi, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 0);
    
        for (int i = lo; i <= hi; i++) {
            power(i, map);
        }
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
                (x, y) -> Objects.equals(map.get(x), map.get(y)) ?
                        -Integer.compare(x, y) : -Integer.compare(map.get(x), map.get(y)));
    
        for (int i = lo; i <= hi; i++) {
            if (maxHeap.size() < k) {
                maxHeap.offer(i);
            } else {
                int top = maxHeap.peek();
                if (map.get(i) < map.get(top) || (map.get(i).equals(map.get(top)) && i < top)) {
                    maxHeap.poll();
                    maxHeap.offer(i);
                }
            }
        }
        
        return maxHeap.peek();
    }
    
    private int power(int n, Map<Integer, Integer> map) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        
        if (n % 2 == 0) {
            map.put(n, 1 + power(n / 2, map));
        } else {
            map.put(n, 1 + power(n * 3 + 1, map));
        }
        
        return map.get(n);
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().getKth(12, 15, 2));
    }
}
