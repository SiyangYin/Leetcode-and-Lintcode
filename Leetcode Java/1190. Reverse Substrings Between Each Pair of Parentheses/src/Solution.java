public class Solution {
    public String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ')') {
                int j = sb.length() - 1;
                while (sb.charAt(j) != '(') {
                    j--;
                }
                
                StringBuilder tmp = new StringBuilder(sb.substring(j + 1)).reverse();
                sb.setLength(j);
                sb.append(tmp);
            } else {
                sb.append(ch);
            }
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().reverseParentheses("(u(love)i)"));
    }
}
