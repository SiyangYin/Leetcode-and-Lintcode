public class Solution {
    /**
     * @param s: a message being encoded
     * @return: an integer
     */
    public int numDecodings(String s) {
        // write your code here
        int n = s.length();
        long mod = (long) (1e9 + 7);
        long[] f = new long[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            char ch = s.charAt(i - 1), prev = 0;
            if (i >= 2) {
                prev = s.charAt(i - 2);
            }
            
            if (ch == '*') {
                f[i] = (f[i] + 9 * f[i - 1]) % mod;
                
                if (i >= 2) {
                    if (prev == '1') {
                        f[i] = (f[i] + 9 * f[i - 2]) % mod;
                    } else if (prev == '2') {
                        f[i] = (f[i] + 6 * f[i - 2]) % mod;
                    } else if (prev == '*') {
                        f[i] = (f[i] + 15 * f[i - 2]) % mod;
                    }
                }
            } else {
                if (ch != '0') {
                    f[i] = (f[i] + f[i - 1]) % mod;
                }
                
                if (i >= 2) {
                    if (prev == '1') {
                        f[i] = (f[i] + f[i - 2]) % mod;
                    } else if (prev == '2') {
                        if (ch <= '6') {
                            f[i] = (f[i] + f[i - 2]) % mod;
                        }
                    } else if (prev == '*') {
                        if (ch <= '6') {
                            f[i] = (f[i] + 2 * f[i - 2]) % mod;
                        } else {
                            f[i] = (f[i] + f[i - 2]) % mod;
                        }
                    }
                }
            }
        }
        
        return (int) f[n];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().numDecodings("1*"));
        System.out.println(new Solution().numDecodings("**1**"));
    }
}
