import java.util.Arrays;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] ways = new int[amount + 1];
        Arrays.fill(ways, amount + 1);
//        Arrays.fill(ways, Integer.MAX_VALUE);
        ways[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    ways[i] = Math.min(ways[i], ways[i - coins[j]] + 1);
                }
            }
        }
        return ways[amount] == amount + 1 ? -1 : ways[amount];
    }
    
    public static void main(String[] args) {
//        System.out.println(new Solution().coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(new Solution().coinChange(new int[]{2, 5, 7}, 13));
        System.out.println(new Solution().coinChange(new int[]{186, 419, 83, 408}, 6249));
    
    }
}
