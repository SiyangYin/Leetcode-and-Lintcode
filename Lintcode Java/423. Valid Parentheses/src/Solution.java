import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    /**
     * @param s: A string
     * @return: whether the string is a valid parentheses
     */
    public boolean isValidParentheses(String s) {
        // write your code here
        if (s == null || s.isEmpty()) {
            return true;
        }
        
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (isLeft(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty() || !check(stack.peek(), s.charAt(i))) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        
        return stack.isEmpty();
    }
    
    private boolean isLeft(char c) {
        return c == '(' || c == '[' || c == '{';
    }
    
    private boolean check(char c1, char c2) {
        switch (c1) {
            case '(': return c2 == ')';
            case '[': return c2 == ']';
            case '{': return c2 == '}';
            default: return false;
        }
    }
}