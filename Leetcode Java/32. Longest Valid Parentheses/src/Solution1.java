import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Solution1 {
    public int longestValidParentheses(String s) {
        Deque<List> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' && !stack.isEmpty() && (char) stack.peek().get(0) == '(') {
                stack.pop();
            }
            else {
                stack.push(Arrays.asList(s.charAt(i), i));
            }
        }
        int max = 0;
        int pre = s.length();
        while (!stack.isEmpty()) {
            int cur = (int) stack.pop().get(1);
            if (pre - cur - 1 > max) {
                max = pre - cur - 1;
            }
            pre = cur;
        }
        if (pre - 0 > max) {
            max = pre;
        }
        return max;
    }
    
    public static void main(String[] args) {
        String s = "()))((())";
        s = "(()";
        s = ")()())";
        s = "(()()";
        System.out.println(new Solution1().longestValidParentheses(s));
    }
}
