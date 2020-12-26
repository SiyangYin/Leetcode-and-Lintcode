import java.util.Arrays;

public class Solution2 {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (isPrime[i]) {
                for (int j = 2; i * j < n; j++) {
                    isPrime[i * j] = false;
                }
            }
        }
        
        int res = 0;
        for (boolean p : isPrime) {
            if (p) {
                res++;
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution2().countPrimes(10));
    }
}
