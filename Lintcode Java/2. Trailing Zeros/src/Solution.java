public class Solution {
    /*
     * @param n: An integer
     * @return: An integer, denote the number of trailing zeros in n!
     */
    public long trailingZeros(long n) {
        // write your code here, try to do it without arithmetic operators.
        long count = 0;
        while (n != 0) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().trailingZeros(25));
    }
}