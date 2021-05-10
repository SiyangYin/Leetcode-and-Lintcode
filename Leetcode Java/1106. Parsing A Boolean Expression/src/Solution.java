import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public boolean parseBoolExpr(String expression) {
        Deque<Character> ops = new ArrayDeque<>(), stk = new ArrayDeque<>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == ',') {
                continue;
            }
            
            if (ch == '&' || ch == '|' || ch == '!') {
                ops.push(ch);
            } else if (ch == '(' || ch == 't' || ch == 'f') {
                stk.push(ch);
            } else {
                // ch == ')'
                char op = ops.pop(), x = stk.pop();
                if (op == '!') {
                    stk.pop();
                    stk.push(x == 't' ? 'f' : 't');
                } else {
                    boolean cur = x == 't';
                    while (stk.peek() != '(') {
                        if (op == '&') {
                            cur &= stk.pop() == 't';
                        } else {
                            cur |= stk.pop() == 't';
                        }
                    }
                    
                    stk.pop();
                    stk.push(cur ? 't' : 'f');
                }
            }
        }
        
        return stk.peek() == 't';
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().parseBoolExpr("|(&(t,f,t),!(t))"));
    }
}
