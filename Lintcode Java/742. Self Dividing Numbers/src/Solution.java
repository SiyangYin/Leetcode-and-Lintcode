import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param lower: Integer : lower bound
     * @param upper: Integer : upper bound
     * @return: a list of every possible Digit Divide Numbers
     */
    public List<Integer> digitDivideNums(int lower, int upper) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        if (lower > upper) {
            return res;
        }
    
        for (long i = lower; i <= upper; i++) {
            int num = (int) i;
            if (check(num)) {
                res.add(num);
            }
        }
        
        return res;
    }
    
    private boolean check(int n) {
        int m = n;
        while (n > 0) {
            int tmp = n % 10;
            if (tmp == 0 || m % tmp != 0) {
                return false;
            }
            n /= 10;
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().digitDivideNums(2147483000, 2147483647));
    }
}
