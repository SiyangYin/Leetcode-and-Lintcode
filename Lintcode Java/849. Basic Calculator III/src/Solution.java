import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * @param s: the expression string
     * @return: the answer
     */
    public int calculate(String s) {
        // Write your code here
        Map<Character, Integer> prio = new HashMap<>();
        prio.put('(', 1);
        prio.put('+', 2);
        prio.put('-', 2);
        prio.put('*', 3);
        prio.put('/', 3);
        
        Deque<Character> ops = new ArrayDeque<>();
        Deque<Long> stack = new ArrayDeque<>();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                continue;
            }
            
            if (ch == '(') {
                ops.push('(');
            } else if (ch == ')') {
                while (ops.peek() != '(') {
                    calc(stack, ops);
                }
                ops.pop();
            } else if (Character.isDigit(ch)) {
                int j = i;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    j++;
                }
                
                Long num = Long.parseLong(s.substring(i, j));
                stack.push(num);
                i = j - 1;
            } else {
                while (!ops.isEmpty() && prio.get(ops.peek()) >= prio.get(ch)) {
                    calc(stack, ops);
                }
                
                ops.push(ch);
            }
        }
        
        while (stack.size() > 1) {
            calc(stack, ops);
        }
        
        long res = stack.peek();
        return (int) res;
    }
    
    private void calc(Deque<Long> stack, Deque<Character> ops) {
        long n2 = stack.pop(), n1 = stack.pop();
        switch (ops.pop()) {
            case '+': stack.push(n1 + n2); break;
            case '-': stack.push(n1 - n2); break;
            case '*': stack.push(n1 * n2); break;
            case '/': stack.push(n1 / n2); break;
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().calculate("2-4-(8+2-6+(8+4-(1)+8-10))"));
    }
}
