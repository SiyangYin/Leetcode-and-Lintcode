import java.util.ArrayDeque;
import java.util.Deque;

public class Solution3 {
    public int longestValidParentheses(String s) {
        int res = 0;
        Deque<Integer> stk = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (!stk.isEmpty() && s.charAt(i) == ')' && s.charAt(stk.peek()) == '(') {
                stk.pop();
                res = Math.max(res, i - (stk.isEmpty() ? -1 : stk.peek()));
            }
            else {
                stk.push(i);
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        String s = "()))((())";
        s = "(()";
        s = ")()())";
        s = "(()()";
        System.out.println(new Solution3().longestValidParentheses(s));
    }
}
