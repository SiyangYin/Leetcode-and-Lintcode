public class Solution {
    /**
     * @param N: a positive integer N
     * @return: return a maximum integer less than N, each digit of which must be monotonically increasing.
     */
    public long getIncreasingNumber(long N) {
        // write your code here
        String s = String.valueOf(N);
        int[] n = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            n[i] = s.charAt(i) - '0';
        }
        
        while (true) {
            modify(n);
            if (check(n)) {
                break;
            }
        }
        
        long res = 0;
        for (int i = 0; i < n.length; i++) {
            res *= 10;
            res += n[i];
        }
        
        return res;
    }
    
    private void modify(int[] n) {
        int idx = -1;
        for (int i = 0; i < n.length; i++) {
            if (i < n.length - 1 && n[i] >= n[i + 1]) {
                idx = i;
                break;
            }
        }
        
        if (idx != -1) {
            n[idx]--;
            for (int i = n.length - 1, j = 9; i > idx; i--, j--) {
                n[i] = j;
            }
        } else {
            n[n.length - 1]--;
        }
    }
    
    private boolean check(int[] s) {
        for (int i = 0; i < s.length - 1; i++) {
            if (s[i] >= s[i + 1]) {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().getIncreasingNumber(998));
        System.out.println(new Solution().getIncreasingNumber(1341));
        System.out.println(new Solution().getIncreasingNumber(100));
        // System.out.println((long) 1E11);
        // System.out.println("0123456789");
    }
}
