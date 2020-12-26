import java.util.ArrayDeque;
import java.util.Deque;

public class Solution2 {
    public boolean checkValidString(String s) {
        Deque<Integer> stack = new ArrayDeque<>(), star = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(i);
            } else if (ch == '*') {
                star.push(i);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else if (!star.isEmpty()){
                    star.pop();
                } else {
                    return false;
                }
            }
        }
        
        while (!stack.isEmpty() && !star.isEmpty()) {
            if (stack.peek() < star.peek()) {
                stack.pop();
                star.pop();
            } else {
                return false;
            }
        }
        
        return stack.isEmpty();
    }
}
