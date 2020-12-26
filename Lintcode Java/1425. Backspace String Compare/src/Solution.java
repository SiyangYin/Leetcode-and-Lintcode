public class Solution {
    /**
     * @param S: string S
     * @param T: string T
     * @return: Backspace String Compare
     */
    public boolean backspaceCompare(String S, String T) {
        // Write your code here
        return calc(S).equals(calc(T));
    }
    
    private String calc(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                if (sb.length() >= 1) {
                    sb.setLength(sb.length() - 1);
                } else {
                    sb.setLength(0);
                }
            } else {
                sb.append(s.charAt(i));
            }
        }
        
        return sb.toString();
    }
}
