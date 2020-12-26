public class Solution2 {
    /**
     * @param n: The number of 'A'
     * @return: the minimum number of steps to get n 'A'
     */
    public int minSteps(int n) {
        // Write your code here
        int res = 0;
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                res += i;
                n /= i;
            }
        }
        
        return res;
    }
    
    
}
