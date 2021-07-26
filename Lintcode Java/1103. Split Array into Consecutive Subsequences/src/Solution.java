import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * @param nums: a list of integers
     * @return: return a boolean
     */
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>(), tail = new HashMap<>();
        for (int x : nums) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }
        
        for (int x : nums) {
            if (!freq.containsKey(x)) {
                continue;
            }
            
            if (tail.containsKey(x - 1)) {
                deleteOnce(freq, x);
                deleteOnce(tail, x - 1);
                tail.put(x, tail.getOrDefault(x, 0) + 1);
            } else if (freq.containsKey(x + 1) && freq.containsKey(x + 2)) {
                deleteOnce(freq, x);
                deleteOnce(freq, x + 1);
                deleteOnce(freq, x + 2);
                tail.put(x + 2, tail.getOrDefault(x + 2, 0) + 1);
            } else {
                return false;
            }
        }
        
        return true;
    }
    
    private void deleteOnce(Map<Integer, Integer> map, int x) {
        map.put(x, map.get(x) - 1);
        if (map.get(x) == 0) {
            map.remove(x);
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().isPossible(new int[]{1, 2, 3, 3, 4, 5}));
        System.out.println(new Solution().isPossible(new int[]{1, 2, 3, 3, 4, 4, 5, 5}));
    }
}
