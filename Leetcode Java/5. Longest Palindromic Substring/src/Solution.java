public class Solution {
    
    private long[] hashL, hashR;
    private long[] pow;
    private int start, end;
    
    public String longestPalindrome(String s) {
        int n = s.length();
        hashL = new long[n + 1];
        hashR = new long[n + 1];
        long P = 131L;
        
        pow = new long[n + 1];
        pow[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow[i] = pow[i - 1] * P;
        }
        
        for (int i = 0; i < n; i++) {
            hashL[i + 1] = hashL[i] * P + s.charAt(i);
            hashR[n - 1 - i] = hashR[n - i] * P + s.charAt(n - 1 - i);
        }
        
        int l = 0, r = n / 2;
        while (l < r) {
            int mid = l + (r - l + 1 >> 1);
            if (check(mid, n)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        
        return s.substring(start, end + 1);
    }
    
    boolean check(int len, int n) {
        // odd
        for (int i = len; i + len < n; i++) {
            if (hashLeft(i - len, i - 1) == hashRight(i + 1, i + len)) {
                start = i - len;
                end = i + len;
                return true;
            }
        }
        
        // even
        for (int i = len - 1; i + len < n; i++) {
            if (hashLeft(i - len + 1, i) == hashRight(i + 1, i + len)) {
                start = i - len + 1;
                end = i + len;
                return true;
            }
        }
        
        return false;
    }
    
    long hashLeft(int l, int r) {
        return hashL[r + 1] - hashL[l] * pow[r - l + 1];
    }
    
    long hashRight(int l, int r) {
        return hashR[l] - hashR[r + 1] * pow[r - l + 1];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("babad"));
    }
}
