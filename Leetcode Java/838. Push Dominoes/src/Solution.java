public class Solution {
    public String pushDominoes(String s) {
        int n = s.length();
        char[] chs = s.toCharArray();
        // R ... L
        for (int i = 0, pos = -1; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '.') {
                continue;
            }
            
            if (ch == 'R') {
                pos = i;
            } else {
                if (pos != -1) {
                    for (int l = pos + 1, r = i - 1; l < r; l++, r--) {
                        chs[l] = 'R';
                        chs[r] = 'L';
                    }
                    
                    pos = -1;
                }
            }
        }
    
        for (int i = 1; i < n; i++) {
            if (chs[i] == '.' && chs[i - 1] == 'R' && (i == n - 1 || chs[i + 1] != 'L')) {
                chs[i] = 'R';
            }
        }
    
        for (int i = n - 2; i >= 0; i--) {
            if (chs[i] == '.' && chs[i + 1] == 'L' && (i == 0 || chs[i - 1] != 'R')) {
                chs[i] = 'L';
            }
        }
        
        return new String(chs);
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().pushDominoes("R.R...L"));
    }
}
