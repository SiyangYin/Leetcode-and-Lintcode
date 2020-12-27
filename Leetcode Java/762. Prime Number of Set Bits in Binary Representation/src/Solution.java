import java.util.Arrays;

public class Solution {
    public int countPrimeSetBits(int L, int R) {
        boolean[] isPrime = new boolean[32];
        build(isPrime);
    
        int res = 0;
        for (int i = L; i <= R; i++) {
            if (isPrime[count1(i)]) {
                res++;
            }
        }
        
        return res;
    }
    
    private int count1(int x) {
        int count = 0;
        while (x != 0) {
            x -= lowbit(x);
            count++;
        }
        
        return count;
    }
    
    private int lowbit(int x) {
        return x & -x;
    }
    
    private void build(boolean[] isPrime) {
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i < isPrime.length; i++) {
            if (!isPrime[i]) {
                continue;
            }
            
            for (int j = 2; j * i < isPrime.length; j++) {
                isPrime[j * i] = false;
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE).length());
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE).length());
    }
}
