public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        
        if (s.isBlank()) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                int j = i + 1;
                while (j < s.length() && s.charAt(j) != ' ') {
                    j++;
                }
                sb.append(new StringBuilder(s.substring(i, j)).reverse()).append(' ');
                i = j;
            }
        }
        
        sb.setLength(sb.length() - 1);
        return sb.reverse().toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().reverseWords("the sky is blue"));
        System.out.println(new Solution().reverseWords("   hello world!  "));
    }
}
