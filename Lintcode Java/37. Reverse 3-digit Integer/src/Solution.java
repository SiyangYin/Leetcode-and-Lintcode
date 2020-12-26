public class Solution {
    /**
     * @param number: A 3-digit number.
     * @return: Reversed number.
     */
    public int reverseInteger(int number) {
        // write your code here
        int n = 0;
        while (number != 0) {
            n *= 10;
            n += number % 10;
            number /= 10;
        }
        return n;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().reverseInteger(123));
        System.out.println(-3 % 2);
    }
}