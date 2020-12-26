public class Solution {
    /**
     * @param s: the original string
     * @return: the string without arbitrary spaces
     */
    public String removeExtra(String s) {
        // write your code here
        if (s == null || s.isEmpty()) {
            return s;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                sb.append(s.charAt(i));
            } else {
                if (sb.length() == 0) {
                    continue;
                }
                
                sb.append(' ');
                while (i < s.length() && s.charAt(i) == ' ') {
                    i++;
                }
                i--;
            }
        }
     
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ' ') {
            sb.setLength(sb.length() - 1);
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().removeExtra("The     sky   is blue  "));
        System.out.println(new Solution().removeExtra("         The     sky   is blue  "));
    }
}
