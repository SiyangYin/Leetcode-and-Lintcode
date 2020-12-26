public class Solution {
    /**
     * @param n: the given number
     * @return:  the double factorial of the number
     */
    public long doubleFactorial(int n) {
        // Write your code here
        long res = 1;
        while (n > 1) {
            res *= n;
            n -= 2;
        }
        
        return res;
    }
}
