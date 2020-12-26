public class Solution {
    /**
     * @param n: the given number
     * @return:  return true if it has exactly three distinct factors, otherwise false
     */
    public boolean isThreeDisctFactors(long n) {
        // write your code here
        if (n == 1) {
            return false;
        }
        
        long i = (long) Math.sqrt(n);
        if (i * i != n) {
            return false;
        }
    
        for (long j = 2; j < Math.sqrt(i); j++) {
            if (i % j == 0) {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().isThreeDisctFactors(1));
    }
}
