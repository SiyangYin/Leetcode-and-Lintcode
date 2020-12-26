public class Solution {
    /**
     * @param s: the string
     * @param k: the max time to remove characters
     * @return: Please output the new string with the smallest lexicographic order.
     */
    public String MinimumString(char[] s, int k) {
        // Write your code here
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length; i++) {
            while (sb.length() > 0 && sb.charAt(sb.length() - 1) > s[i] && k > 0) {
                sb.setLength(sb.length() - 1);
                k--;
            }
            
            sb.append(s[i]);
        }
        
        sb.setLength(sb.length() - k);
        return sb.toString();
    }
    
    public static void main(String[] args) {
        char[] s = "accacbcbcacababbacbbacbbbaabbcbbccbaccccaababcabacbcbaacbbabbacabcacaacaccaccccbbbbaaccbccbbbbbacacbbabbbcaabcbbcaacaaacbaaaccbccbbabaababcbcccabbacabccccccccbcb".toCharArray();
        System.out.println(new Solution().MinimumString(s, 100));
    }
}
