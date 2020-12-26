public class Solution {
    /**
     * @param n: The guest paid
     * @param m: the price
     * @return: the sum of the number of banknotes
     */
    public int coinProblem(int n, int m) {
        // Write your code here
        int[] coins = {100, 50, 20, 10, 5, 2, 1};
        int x = n - m;
        
        int res = 0;
        for (int i = 0; i < coins.length; i++) {
            res += x / coins[i];
            x %= coins[i];
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().coinProblem(100, 29));
    }
}
