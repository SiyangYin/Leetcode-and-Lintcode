public class Solution {
    /**
     * @param num: an integer
     * @return: whether the integer is a power of 4
     */
    public boolean isPowerOfFour(int num) {
        // Write your code here
        if (num < 1) {
            return false;
        }
        if ((num & (num - 1)) != 0) {
            return false;
        }
        while (num > 1) {
            num >>= 2;
        }
        if (num == 1) {
            return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().isPowerOfFour(16));
    }
}