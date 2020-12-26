public class Solution {
    public static void main(String[] args) {
        System.out.println(isPalindrome(1881));
    }
    
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        
        int reversedNumber = 0, n = x;
        while (n != 0) {
            reversedNumber *= 10;
            reversedNumber += n % 10;
            n /= 10;
        }
        
        return x == reversedNumber;
    }
}