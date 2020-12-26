public class Solution {
    public boolean isPowerOfThree(int n) {
        if (n == 0) {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        if (n == 1) {
            return true;
        } else {
            return false;
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().isPowerOfThree(28));
    }
}