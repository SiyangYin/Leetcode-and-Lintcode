import java.util.Arrays;

public class Solution {
    /**
     * @param a: the array
     * @param k: the target
     * @return: the sum of the legal set
     */
    public int theSumofLegalSet(int[] a, int k) {
        // Write your code here.
        Arrays.sort(a);
        
        long res = 0, MOD = (long) (1E9 + 7);
        for (int i = 0, j = a.length - 1; i <= j; ) {
            if (a[i] + a[j] <= k) {
                res += pow2(j - i, MOD);
                res %= MOD;
                i++;
            } else {
                j--;
            }
        }
        
        return (int) res;
    }
    
    private long pow2(int n, long MOD) {
        long res = 1, p = 2;
        while (n > 0) {
            if ((n & 1) == 1) {
                res *= p;
                res %= MOD;
            }
            
            p *= p;
            p %= MOD;
            n >>= 1;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().theSumofLegalSet(new int[]{3, 2, 5, 7, 9}, 10));
        System.out.println(new Solution().theSumofLegalSet(new int[]{3, 2, 4, 5}, 6));
        
        System.out.println(1000000007);
        System.out.println((int) 1E9 + 7);
    
        System.out.println(new Solution().pow2(10, (long) 1E9));
        // System.out.println(Math.pow(2, 10000));
    }
}
