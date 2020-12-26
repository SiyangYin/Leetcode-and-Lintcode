public class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }
        while ((n & 1) == 0) {
            n >>= 1;
        }
        if (n == 1){
            return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().isPowerOfTwo(3));
    }
}