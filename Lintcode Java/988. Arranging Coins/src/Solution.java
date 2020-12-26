public class Solution {
    /**
     * @param n: a non-negative integer
     * @return: the total number of full staircase rows that can be formed
     */
    public int arrangeCoins(int n) {
        // Write your code here
        int sum = 0, i = 1;
        while (true) {
            if (sum + i > n) {
                return i - 1;
            }
            
            sum += i;
            i++;
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().arrangeCoins(5));
    }
}
