import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /*
     * @param k: An integer
     * @return: all amicable pairs
     */
    public List<List<Integer>> amicablePair(int k) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        
        for (int i = 2; i <= k; i++) {
            int sum = sumOfFac(i);
            if (sum <= i || sum > k) {
                continue;
            }
            
            if (sumOfFac(sum) == i) {
                res.add(Arrays.asList(i, sum));
            }
        }
        
        return res;
    }
    
    private int sumOfFac(int n) {
        int i = 0, sum = 1;
        for (i = 2; i * i < n; i++) {
            if (n % i == 0) {
                sum += i + n / i;
            }
        }
        
        if (i * i == n) {
            sum += i;
        }
        
        return sum;
    }
}
