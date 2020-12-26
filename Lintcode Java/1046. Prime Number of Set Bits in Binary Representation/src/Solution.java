public class Solution {
    /**
     * @param L: an integer
     * @param R: an integer
     * @return: the count of numbers in the range [L, R] having a prime number of set bits in their binary representation
     */
    public int countPrimeSetBits(int L, int R) {
        // write your code here
        boolean[] check = {false,
                false, true, true, false, true,
                false, true, false, false, false,
                true, false, true, false, false,
                false, true, false, true, false,
                false, false, true, false, false,
                false, false, false, true, false,
                true, false};
    
        int res = 0;
        for (int i = L; i <= R; i++) {
            if (check[cal(i)]) {
                res++;
            }
        }
        
        return res;
    }
    
    private int cal(int n) {
        int res = 0;
        while (n > 0) {
            n -= lowbit(n);
            res++;
        }
        
        return res;
    }
    
    private int lowbit(int x) {
        return x & -x;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().countPrimeSetBits(6, 10));
    }
}
