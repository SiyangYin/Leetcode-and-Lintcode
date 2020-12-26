public class Solution {
    /**
     * @param s1: the 1st string
     * @param s2: the 2nd string
     * @return: uncommon characters of given strings
     */
    public String concatenetedString(String s1, String s2) {
        // write your code here
        int[] mark = new int[26];
        for (int i = 0; i < s2.length(); i++) {
            mark[s2.charAt(i) - 'a'] = 1;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            if (mark[ch - 'a'] == 0) {
                sb.append(ch);
            } else {
                mark[ch - 'a'] = 2;
            }
        }
    
        for (int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);
            if (mark[ch - 'a'] != 2) {
                sb.append(ch);
            }
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().concatenetedString("abcs", "cxzca"));
    }
}
