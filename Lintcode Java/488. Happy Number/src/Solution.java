import java.util.HashSet;
import java.util.Set;

public class Solution {
    /**
     * @param n: An integer
     * @return: true if this is a happy number or false
     */
    public boolean isHappy(int n) {
        // write your code here
        Set<Integer> set = new HashSet<>();
        set.add(n);
        int i = 0;
        while ((i = sum(n)) != 1) {
            if (!set.add(i)) {
                return false;
            }
            n = i;
        }
        
        return true;
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
