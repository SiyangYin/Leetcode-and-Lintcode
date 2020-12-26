public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        
        StringBuilder res = new StringBuilder(), sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                sb.append(s.charAt(i));
            } else {
                res.append(sb.reverse()).append(' ');
                sb.setLength(0);
            }
        }
        res.append(sb.reverse());
        return res.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().reverseWords("Let's take LeetCode contest"));
    }
}
