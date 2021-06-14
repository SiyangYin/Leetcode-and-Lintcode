public class Solution {
    /**
     * @param S: a string
     * @param K: a integer
     * @return: return a string
     */
    public String licenseKeyFormatting(String S, int K) {
        // write your code here
        StringBuilder sb = new StringBuilder();
        for (int i = S.length() - 1, j = 0; i >= 0; i--) {
            char ch = S.charAt(i);
            if (ch != '-') {
                sb.append(Character.toUpperCase(ch));
                j++;
            }
    
            if (j == K ) {
                sb.append('-');
                j = 0;
            }
        }
        
        if (sb.charAt(sb.length() - 1) == '-') {
            sb.setLength(sb.length() - 1);
        }
        
        return sb.reverse().toString();
    }
}
