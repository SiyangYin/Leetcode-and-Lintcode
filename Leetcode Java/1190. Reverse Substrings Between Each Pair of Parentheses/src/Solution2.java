import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public String reverseParentheses(String s) {
        Deque<Integer> stk = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stk.push(i);
            } else if (ch == ')') {
                map.put(i, stk.peek());
                map.put(stk.pop(), i);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0, step = 1; i < s.length(); i += step) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == ')') {
                i = map.get(i);
                step = -step;
            } else {
                sb.append(ch);
            }
        }
        
        return sb.toString();
    }
}
