import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * @param n: a integer
     * @return: return a integer
     */
    public int countPrimes(int n) {
        // write your code here
        if (n <= 2) {
            return 0;
        }
        
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
    
            for (int j = 0; i * primes.get(j) < n; j++) {
                isPrime[i * primes.get(j)] = false;
                if (i % primes.get(j) == 0) {
                    break;
                }
            }
        }
        
        return primes.size();
    }
}
