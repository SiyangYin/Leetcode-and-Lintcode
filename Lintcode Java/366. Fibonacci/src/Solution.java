public class Solution {
    /**
     * @param n: an integer
     * @return: an ineger f(n)
     */
    public int fibonacci(int n) {
        // write your code here
        if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        }
        
        int n1 = 0, n2 = 1;
        for (int i = 2; i < n; i++) {
            n2 += n1;
            n1 = n2 - n1;
        }
        
        return n2;
    }
}
