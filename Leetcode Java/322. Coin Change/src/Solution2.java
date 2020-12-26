import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        
        Map<Integer, Integer> ways = new HashMap<>();
        
        int result = dfs(coins, amount, ways);
        System.out.println(ways);
        return result == Integer.MAX_VALUE ? -1 : result;
    }
    
    private int dfs(int[] coins, int amount, Map<Integer, Integer> ways) {
        if (amount < 0) {
            return Integer.MAX_VALUE;
        }
        if (amount == 0) {
            return 0;
        }
        if (ways.containsKey(amount)) {
            return ways.get(amount);
        }
        
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            if (amount >= coins[i]) {
                int tmp = dfs(coins, amount - coins[i], ways);
                if (tmp != Integer.MAX_VALUE) {
                    ans = Math.min(ans, 1 + tmp);
                }
            }
        }
        
        if (ans != Integer.MAX_VALUE) {
            ways.put(amount, ans);
        } else {
            ways.put(amount, Integer.MAX_VALUE);
        }
        
        return ans;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution2().coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(new Solution2().coinChange(new int[]{2}, 3));
        System.out.println(new Solution2().coinChange(new int[]{2, 5, 7}, 13));
        
        // System.out.println(new Solution2().coinChange(new int[]{186, 419, 83, 408}, 6249));
    }
}
