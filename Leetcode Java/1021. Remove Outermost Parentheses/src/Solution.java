public class Solution {
    public String removeOuterParentheses(String S) {
        StringBuilder sb = new StringBuilder();
        int leftCount = 0;
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (ch == '(') {
                leftCount++;
                if (leftCount != 1) {
                    sb.append('(');
                }
            } else {
                leftCount--;
                if (leftCount != 0) {
                    sb.append(')');
                }
            }
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().removeOuterParentheses("(()())(())"));
    }
}
