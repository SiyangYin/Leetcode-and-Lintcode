public class Solution {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1, j = k; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch != '-') {
                if (j == 0) {
                    j = k;
                    sb.append('-');
                }
                j--;
                sb.append(Character.toUpperCase(ch));
            }
        }
        
        return sb.reverse().toString();
    }
}
