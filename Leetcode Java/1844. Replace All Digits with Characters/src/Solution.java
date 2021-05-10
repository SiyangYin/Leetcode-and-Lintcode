public class Solution {
    public String replaceDigits(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (i % 2 == 0) {
                sb.append(ch);
            } else {
                sb.append((char) (s.charAt(i - 1) + ch - '0'));
            }
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().replaceDigits("a1c1e1"));
    }
}
