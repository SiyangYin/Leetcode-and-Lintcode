import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        
        int res = 0;
        
        Deque<Integer> stack = new ArrayDeque<>();
        int start = 0;
    
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    start = i + 1;
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        res = Math.max(res, i - start + 1);
                    } else {
                        res = Math.max(res, i - stack.peek());
                    }
                }
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        String s = "()))((())";
        s = "(()";
        s = ")()())";
        s = "(()()";
        System.out.println(new Solution().longestValidParentheses(s));
    }
}
