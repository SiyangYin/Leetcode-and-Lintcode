public class Solution {
    /**
     * @param amount: The amount you should pay.
     * @return: Return the minimum number of coins for change.
     */
    public int giveChange(int amount) {
        // write you code here.
        int x = 1024 - amount;
        int res = 0;
        int[] coins = {64, 16, 4, 1};
        for (int i = 0; i < 4; i++) {
            res += x / coins[i];
            x %= coins[i];
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().giveChange(1014));
    }
}
