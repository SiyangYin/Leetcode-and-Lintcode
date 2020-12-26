public class Solution {
    /**
     * @param a: the given number
     * @param b: another number
     * @return: the greatest common divisor of two numbers
     */
    public int gcd(int a, int b) {
        // write your code here
        if (a * b == 0) {
            return a + b;
        }
        
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        
        return a;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().gcd(10, 15));
    }
}
