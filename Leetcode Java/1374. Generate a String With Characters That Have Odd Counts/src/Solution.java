public class Solution {
    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append('a');
        }
        
        if (n % 2 == 0) {
            sb.setCharAt(sb.length() - 1, 'b');
        }
        
        return sb.toString();
    }
}
