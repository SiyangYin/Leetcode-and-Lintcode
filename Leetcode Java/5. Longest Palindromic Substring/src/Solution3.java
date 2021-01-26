public class Solution3 {
    
    private long[] hashL, hashR;
    private long[] p;
    private int start, end;
    
    public String longestPalindrome(String s) {
        int n = s.length();
        hashL = new long[n + 1];
        hashR = new long[n + 1];
        long P = 131L, hashl = 0, hashr = 0;
        
        p = new long[n + 1];
        p[0] = 1;
        for (int i = 1; i <= n; i++) {
            p[i] = p[i - 1] * P;
        }
        
        for (int i = 0; i < n; i++) {
            hashL[i + 1] = hashl = hashl * P + s.charAt(i);
            hashR[n - 1 - i] = hashr = hashr * P + s.charAt(n - 1 - i);
        }
        
        binarySearch(0, n / 2, n, true);
        binarySearch(1, n / 2, n, false);
        
        return s.substring(start, end + 1);
    }
    
    private void binarySearch(int l, int r, int n, boolean odd) {
        while (l <= r) {
            int m = l + (r - l + 1 >> 1);
            boolean found = false;
            for (int i = 0; i < n; i++) {
                int left = i - m + (odd ? 0 : 1), right = i + m;
                if (left < 0) {
                    continue;
                }
                if (right > n - 1) {
                    break;
                }
                
                if (hash(left, i, true) == hash(i + (odd ? 0 : 1), right, false)) {
                    found = true;
                    if (right - left > end - start) {
                        start = left;
                        end = right;
                    }
                    break;
                }
            }
            
            if (found) {
                l = m;
                if (l == r) {
                    break;
                }
            } else {
                r = m - 1;
            }
        }
    }
    
    private long hash(int l, int r, boolean lToR) {
        return lToR ? hashL[r + 1] - hashL[l] * p[r - l + 1] : hashR[l] - hashR[r + 1] * p[r - l + 1];
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution3().longestPalindrome("babad"));
        System.out.println(new Solution3().longestPalindrome("ccc"));
        // System.out.println(new Solution3().longestPalindrome("tattarrattat"));
        // System.out.println(new Solution3().longestPalindrome("aba"));
    }
}
