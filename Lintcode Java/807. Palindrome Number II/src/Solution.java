public class Solution {
    /**
     * @param n: non-negative integer n.
     * @return: return whether a binary representation of a non-negative integer n is a palindrome.
     */
    public boolean isPalindrome(int n) {
        // Write your code here
        int m = n;
        int rev = 0;
        while (m != 0) {
            rev <<= 1;
            rev += m & 1;
            m >>= 1;
        }
        
        return rev == n;
    }
}
