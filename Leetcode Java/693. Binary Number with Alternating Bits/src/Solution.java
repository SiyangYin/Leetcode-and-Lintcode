public class Solution {
    public boolean hasAlternatingBits(int n) {
        int cur = n & 1;
        n >>= 1;
        while (n > 0) {
            if (cur == (n & 1)) {
                return false;
            }
            
            cur = n & 1;
            n >>= 1;
        }
        
        return true;
    }
}
