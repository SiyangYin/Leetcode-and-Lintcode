import java.util.HashSet;
import java.util.Set;

public class Solution2 {
    public boolean isHappy(int n) {
        // write your code here
        int slow = n, fast = n;
        do {
            slow = sum(slow);
            fast = sum(sum(fast));
            if (fast == 1) {
                return true;
            }
        } while (slow != fast);
        
        return false;
    }
    
    private int sum(int n) {
        int res = 0;
        while (n > 0) {
            int i = n % 10;
            res += i * i;
            n /= 10;
        }
        
        return res;
    }
}
