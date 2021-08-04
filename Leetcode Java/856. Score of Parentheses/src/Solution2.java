import java.util.ArrayDeque;
import java.util.Deque;

public class Solution2 {
    public int scoreOfParentheses(String s) {
        Deque<Integer> stk = new ArrayDeque<>();
        stk.push(0);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stk.push(0);
            } else {
                int top = stk.pop();
                if (top == 0) {
                    top = 1;
                } else {
                    top <<= 1;
                }
                
                stk.push(stk.pop() + top);
            }
        }
        
        return stk.peek();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().scoreOfParentheses("(())"));
        System.out.println(new Solution2().scoreOfParentheses("(())"));
    }
}
