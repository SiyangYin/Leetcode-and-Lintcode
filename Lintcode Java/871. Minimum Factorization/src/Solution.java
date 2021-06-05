public class Solution {
    /**
     * @param a: a positive integer
     * @return: the smallest positive integer whose multiplication of each digit equals to a
     */
    public int smallestFactorization(int a) {
        // Write your code here
        int[] cnt = new int[10];
        for (int i = 9; i >= 2; i--) {
            while (a % i == 0) {
                a /= i;
                cnt[i]++;
            }
        }
        
        long res = 0;
        for (int i = 1; i <= 9; i++) {
            while (cnt[i] > 0) {
                cnt[i]--;
                res = res * 10 + i;
                if (res > Integer.MAX_VALUE) {
                    return 0;
                }
            }
        }
        
        return (int) res;
    }
    
    public static void main(String[] args) {
        System.out.println(String.valueOf(Integer.MAX_VALUE).length());
        System.out.println(new Solution().smallestFactorization(48));
        System.out.println(new Solution().smallestFactorization(11));
    }
}
