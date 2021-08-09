import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<Integer> cheapestJump(int[] coins, int maxJump) {
        int n = coins.length;
        int[] f = new int[n];
        int[] ne = new int[n];
        Arrays.fill(f, -1);
        dfs(0, coins, f, ne, maxJump);
        
        if (f[n - 1] == -1 || f[n - 1] == 0x3f3f3f3f) {
            return new ArrayList<>();
        }
        
        List<Integer> res = new ArrayList<>();
        for (int pos = 0; pos != n - 1; pos = ne[pos]) {
            res.add(pos + 1);
        }
        
        res.add(n);
        return res;
    }
    
    int dfs(int pos, int[] coins, int[] f, int[] ne, int maxJump) {
        if (f[pos] != -1) {
            return f[pos];
        }
        
        int min = 0x3f3f3f3f;
        if (coins[pos] == -1) {
            f[pos] = min;
            return min;
        }
        
        if (pos == coins.length - 1) {
            f[pos] = coins[coins.length - 1];
            return f[pos];
        }
        
        for (int i = 1; i <= maxJump; i++) {
            if (pos + i >= coins.length) {
                break;
            }
            
            int cost = dfs(pos + i, coins, f, ne, maxJump);
            if (coins[pos] + cost < min) {
                min = coins[pos] + cost;
                ne[pos] = pos + i;
            }
        }
        
        f[pos] = min;
        return f[pos];
    }
    
    public static void main(String[] args) {
        int[] c = {1, 2, 4, -1, 2};
        int mj = 1;
        System.out.println(new Solution().cheapestJump(c, mj));
    }
}
