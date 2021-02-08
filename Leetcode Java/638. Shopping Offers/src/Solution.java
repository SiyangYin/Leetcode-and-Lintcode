import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int n = price.size();
        int[][] dp = new int[special.size() + 1][1 << n * 3];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        int target = 0;
        for (int i = needs.size() - 1; i >= 0; i--) {
            target = (target << 3) + needs.get(i);
        }
        
        return dfs(special.size(), target, special, price, dp);
    }
    
    private int dfs(int pos, int state, List<List<Integer>> special, List<Integer> price, int[][] dp) {
        if (dp[pos][state] != -1) {
            return dp[pos][state];
        }
        
        int n = price.size();
        if (pos == 0) {
            dp[pos][state] = 0;
            for (int i = 0; i < n; i++) {
                int c = state >> i * 3 & 7;
                dp[pos][state] += c * price.get(i);
            }
            
            return dp[pos][state];
        }
        
        dp[pos][state] = dfs(pos - 1, state, special, price, dp);
        List<Integer> sp = special.get(pos - 1);
        int nextState = 0;
        for (int i = n - 1; i >= 0; i--) {
            int c = state >> i * 3 & 7;
            if (c < sp.get(i)) {
                nextState = -1;
                break;
            }
            
            nextState = (nextState << 3) + c - sp.get(i);
        }
        
        if (nextState != -1) {
            dp[pos][state] = Math.min(dp[pos][state], sp.get(n) + dfs(pos, nextState, special, price, dp));
        }
        
        return dp[pos][state];
    }
    
    public static void main(String[] args) {
        List<Integer> price = Arrays.asList(2, 6, 7, 10, 2, 4);
        List<List<Integer>> sp = new ArrayList<>();
        sp.add(Arrays.asList(0, 3, 1, 4, 4, 3, 12));
        sp.add(Arrays.asList(3, 3, 3, 3, 4, 5, 25));
        sp.add(Arrays.asList(4, 6, 0, 2, 1, 1, 5));
        sp.add(Arrays.asList(3, 3, 3, 3, 4, 5, 25));
        sp.add(Arrays.asList(1, 3, 0, 4, 4, 2, 6));
        sp.add(Arrays.asList(0, 3, 1, 0, 5, 0, 2));
        sp.add(Arrays.asList(0, 3, 1, 3, 4, 4, 24));
        sp.add(Arrays.asList(6, 0, 1, 3, 4, 2, 19));
        sp.add(Arrays.asList(5, 1, 4, 5, 3, 4, 22));
        List<Integer> need = Arrays.asList(0, 4, 5, 0, 0, 6);
        System.out.println(new Solution().shoppingOffers(price, sp, need));
    }
}
