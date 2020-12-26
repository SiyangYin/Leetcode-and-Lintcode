import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    /**
     * @param deck: a integer array
     * @return: return a value of bool
     */
    public boolean hasGroupsSizeX(List<Integer> deck) {
        // write your code here
        Map<Integer, Integer> map = new HashMap<>();
        for (int d : deck) {
            map.put(d, map.getOrDefault(d, 0) + 1);
        }
        
        int x = deck.size();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            x = Math.min(x, entry.getValue());
        }
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            x = gcd(x, entry.getValue());
            if (x == 1) {
                return false;
            }
        }
        
        return true;
    }
    
    private int gcd(int x, int y) {
        while (y != 0) {
            int tmp = x % y;
            x = y;
            y = tmp;
        }
        
        return x;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().hasGroupsSizeX(Arrays.asList(1, 2, 3, 4, 4, 3, 2, 1)));
    }
}
