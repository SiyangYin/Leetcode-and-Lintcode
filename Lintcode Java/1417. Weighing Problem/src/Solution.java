public class Solution {
    /**
     * @param n: The number of coins
     * @return: The Minimum weighing times int worst case
     */
    public int minimumtimes(int n) {
        // Write your code here
        if (n == 3) {
            return 1;
        } else if (n <= 9) {
            return 2;
        } else {
            if (n % 3 == 0) {
                return 1 + minimumtimes(n / 3);
            } else {
                return 1 + minimumtimes(n / 3 + 1);
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().minimumtimes(10));
        System.out.println(new Solution().minimumtimes(12));
    }
}
