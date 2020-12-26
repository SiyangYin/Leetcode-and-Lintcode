import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int countPrimes(int n) {
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
    
        System.out.println(primes);
        return primes.size();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().countPrimes(100));
    }
}
