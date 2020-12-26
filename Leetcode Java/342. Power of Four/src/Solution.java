public class Solution {
    public boolean isPowerOfFour(int num) {
        if (num <= 0) {
            return false;
        }
        
        if (num != lowbit(num)) {
            return false;
        }
        
        while (num > 0) {
            if ((num & 1) == 1) {
                return true;
            }
            num >>= 2;
        }
        
        return false;
    }
    
    private int lowbit(int x) {
        return x & (-x);
    }
}
