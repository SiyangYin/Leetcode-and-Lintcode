public class Solution {
    /**
     * @param str: the string
     * @param k: the length
     * @return: the substring with  the smallest lexicographic order
     */
    public String deleteChar(String str, int k) {
        // Write your code here.
        if (k == 0) {
            return "";
        }
        
        k = str.length() - k;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            while (sb.length() > 0 && sb.charAt(sb.length() - 1) > c && k > 0) {
                sb.setLength(sb.length() - 1);
                k--;
            }
            
            sb.append(c);
        }
        
        if (k > 0) {
            sb.setLength(sb.length() - k);
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().deleteChar("fskacsbi", 2));
    }
}
