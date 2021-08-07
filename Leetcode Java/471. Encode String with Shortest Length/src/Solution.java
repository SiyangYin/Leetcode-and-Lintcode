public class Solution {
    public String encode(String s) {
        int n = s.length();
        String[][] f = new String[n][n];
        for (int i = 0; i < n; i++) {
            f[i][i] = String.valueOf(s.charAt(i));
        }
        
        for (int len = 2; len <= n; len++) {
            for (int l = 0; l + len - 1 < n; l++) {
                int r = l + len - 1;
                String sub = s.substring(l, r + 1);
                f[l][r] = sub;
                
                int repeatLen = getRepeat(sub);
                if (repeatLen > 0) {
                    int cnt = (r - l + 1) / repeatLen;
                    StringBuilder sb = new StringBuilder();
                    sb.append(cnt).append('[').append(f[l][l + repeatLen - 1]).append(']');
                    if (sb.length() < sub.length()) {
                        f[l][r] = sb.toString();
                    }
                }
                
                for (int i = l; i < r; i++) {
                    if (f[l][i].length() + f[i + 1][r].length() < f[l][r].length()) {
                        f[l][r] = f[l][i] + f[i + 1][r];
                    }
                }
            }
        }
        
        return f[0][n - 1];
    }
    
    int getRepeat(String s) {
        int n = s.length();
        int[] ne = getNext(s);
        int l = ne[n];
        return l != 0 && n % (n - l) == 0 ? n - l : 0;
    }
    
    int[] getNext(String s) {
        int[] ne = new int[s.length() + 1];
        for (int i = 0, j = ne[0] = -1; i < s.length(); ) {
            if (j == -1 || s.charAt(i) == s.charAt(j)) {
                ne[++i] = ++j;
            } else {
                j = ne[j];
            }
        }
        
        return ne;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().getRepeat("abababab"));
        System.out.println(new Solution().encode("abababab"));
    }
}
