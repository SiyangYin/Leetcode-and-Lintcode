import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    /**
     * @param stones: a list of stones' positions in sorted ascending order
     * @return: true if the frog is able to cross the river or false
     */
    public boolean canCross(int[] stones) {
        // write your code here
        int n = stones.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(stones[i], i);
        }
        
        // 跳到f[i]的时候上一步是多少步
        Set<Integer>[] f = (Set<Integer>[]) new HashSet[n];
        for (int i = 0; i < n; i++) {
            f[i] = new HashSet<>();
        }
        f[0].add(0);
        
        for (int i = 0; i < n; i++) {
            int pos = stones[i];
            for (int x : f[i]) {
                if (map.containsKey(pos + x + 1)) {
                    f[map.get(pos + x + 1)].add(x + 1);
                }
                if (x >= 1 && map.containsKey(pos + x)) {
                    f[map.get(pos + x)].add(x);
                }
                if (x >= 2 && map.containsKey(pos + x - 1)) {
                    f[map.get(pos + x - 1)].add(x - 1);
                }
            }
            
            if (!f[n - 1].isEmpty()) {
                return true;
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().canCross(new int[]{0, 1, 2, 3, 4, 8, 9, 11}));
    }
}
