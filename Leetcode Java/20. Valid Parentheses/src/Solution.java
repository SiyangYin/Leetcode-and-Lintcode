import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        
        Deque<Character> stack = new ArrayDeque<>();
        
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '(' || cur == '[' || cur == '{') {
                stack.push(cur);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                
                char top = stack.peek();
                if (match(top, cur)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
    
    private boolean match(char c1, char c2) {
        if ((c1 == '(' && c2 == ')')
                || (c1 == '[' && c2 == ']'
                || (c1 == '{' && c2 == '}'))) {
            return true;
        }
        
        return false;
    }
}
