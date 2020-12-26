import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isValid(i)) {
                res.add(i);
            }
        }
        
        return res;
    }
    
    private boolean isValid(int n) {
        int m = n;
        while (m != 0) {
            int k = m % 10;
            if (k == 0 || n % k != 0) {
                return false;
            }
            
            m /= 10;
        }
        
        return true;
    }
}
