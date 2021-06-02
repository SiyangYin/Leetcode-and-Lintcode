public class Solution {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '-') {
                sb.append(s.charAt(i));
            }
        }
        
        StringBuilder res = new StringBuilder();
        for (int i = sb.length() - 1, j = k; i >= 0; i--, j--) {
            if (j == 0) {
                j = k;
                res.append('-');
            }
            
            res.append(Character.toUpperCase(sb.charAt(i)));
        }
        
        return res.reverse().toString();
    }
}
