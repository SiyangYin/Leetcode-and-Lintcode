public class Solution {
    /**
     * @param num: a positive number
     * @return: true if it's a palindrome or false
     */
    public boolean isPalindrome(int num) {
        // write your code here
        int m = num;
        int rev = 0;
        while (m != 0) {
            rev *= 10;
            rev += m % 10;
            m /= 10;
        }
        
        return num == rev;
    }
}
