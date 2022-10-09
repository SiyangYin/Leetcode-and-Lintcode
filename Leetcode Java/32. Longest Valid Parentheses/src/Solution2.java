import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Solution2 {
    public int longestValidParentheses(String s) {
        Deque<List> stack = new ArrayDeque<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' && !stack.isEmpty() && (char) stack.peek().get(0) == '(') {
                stack.pop();
            }
            else {
                if (stack.isEmpty() && i > max) {
                    max = i;
                }
                else if (!stack.isEmpty() && i - (int) stack.peek().get(1) - 1 > max) {
                    max = i - (int) stack.peek().get(1) - 1;
                }
                stack.push(Arrays.asList(s.charAt(i), i));
            }
        }
        if (stack.isEmpty() && s.length() > max) {
            max = s.length();
        }
        if (!stack.isEmpty() && s.length() - (int) stack.peek().get(1) - 1 > max) {
            max = s.length() - (int) stack.peek().get(1) - 1;
        }
        return max;
    }
    
    public static void main(String[] args) {
        String s = "()))((())";
        s = "(()";
        s = ")()())";
        s = "(()()";
        System.out.println(new Solution2().longestValidParentheses(s));
    }
}
