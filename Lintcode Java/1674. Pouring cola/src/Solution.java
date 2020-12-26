public class Solution {
    /**
     * @param s: the volume of cola
     * @param n: the volume of the first cup
     * @param m: the volume of the second cup
     * @return: the minimum number of times to be inverted
     */
    public int getMinTimes(int s, int n, int m) {
        // Write your code here
        if (s % 2 != 0) {
            return -1;
        }
        
        if (n < m) {
            int tmp = n;
            n = m;
            m = tmp;
        }
        
        if (s / 2 % gcd(n, m) != 0) {
            return -1;
        }
        
        return -1;
    }
    
    private int gcd(int x, int y) {
        while (y != 0) {
            int r = x % y;
            x = y;
            y = r;
        }
        
        return x;
    }
}
