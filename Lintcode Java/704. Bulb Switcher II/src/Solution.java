import java.util.HashSet;
import java.util.Set;

public class Solution {
    /**
     * @param n: number of lights
     * @param m: number of operations
     * @return: the number of status
     */
    public int flipLights(int n, int m) {
        // write your code here
        n = Math.min(n, 6);
        Set<Integer> set = new HashSet<>();
        int[] change = {0b111111, 0b101010, 0b010101, 0b100100};
        
        for (int i = 0; i <= (1 << 4) - 1; i++) {
            int state = 0;
            int bitCount = Integer.bitCount(i);
            if (bitCount % 2 == m % 2 && bitCount <= m) {
                for (int j = 0; j < 4; j++) {
                    if (((i >> j) & 1) == 1) {
                        state ^= change[j];
                    }
                }
                
                state >>= 6 - n;
                set.add(state);
            }
        }
        
        return set.size();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().flipLights(2, 1));
        System.out.println(new Solution().flipLights(5, 5));
    }
}
