public class Solution {
    /**
     * @param n: an integer
     * @return: if n is a power of three
     */
    public boolean isPowerOfThree(int n) {
        // Write your code here
        if (n <= 0) {
            return false;
        }
        
        while (n % 3 == 0) {
            n /= 3;
        }
        
        return n == 1;
    }
}
