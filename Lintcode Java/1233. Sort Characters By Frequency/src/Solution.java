import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    /**
     * @param s:
     * @return: return a string
     */
    public String frequencySort(String s) {
        // write your code here
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((c1, c2) -> {
            if (map.get(c1) != map.get(c2)) {
                return Integer.compare(map.get(c1), map.get(c2));
            } else {
                return Character.compare(c1, c2);
            }
        });
    
        for (char ch : map.keySet()) {
            maxHeap.offer(ch);
        }
        
        StringBuilder sb = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            while (map.get(maxHeap.peek()) > 0) {
                sb.append(maxHeap.peek());
                map.put(maxHeap.peek(), map.get(maxHeap.peek()) - 1);
            }
            
            maxHeap.poll();
        }
        
        return sb.toString();
    }
}
