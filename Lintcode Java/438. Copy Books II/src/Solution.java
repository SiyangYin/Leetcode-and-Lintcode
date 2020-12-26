import java.util.Arrays;

public class Solution {
    /**
     * @param n:     An integer
     * @param times: an array of integers
     * @return: an integer
     */
    public int copyBooksII(int n, int[] times) {
        // write your code here
        Arrays.sort(times);
        
        int l = times[0], r = times[0] * n;
        
        while (l < r) {
            int m = l + (r - l >> 1);
            if (check(times, m, n)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        
        return l;
    }
    
    private boolean check(int[] times, int time, int n) {
        for (int i = 0; i < times.length; i++) {
            int books = time / times[i];
            n -= books;
            if (n <= 0) {
                return true;
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().copyBooksII(4, new int[]{3, 2, 4}));
        System.out.println(new Solution().copyBooksII(100, new int[]{1, 2}));
    }
}
