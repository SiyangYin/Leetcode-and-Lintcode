import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Character> ops = new ArrayDeque<>();
        Map<Character, Integer> prec = new HashMap<>();
        prec.put('(', 1);
        prec.put('+', 2);
        prec.put('-', 2);
        prec.put('*', 3);
        prec.put('/', 3);
    
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                continue;
            }
            
            if (s.charAt(i) == '(') {
                ops.push('(');
            } else if (s.charAt(i) == ')') {
                while (ops.peek() != '(') {
                    oper(stack, ops.pop());
                }
                ops.pop();
            } else if (Character.isDigit(s.charAt(i))) {
                int j = i;
                int num = 0;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    num = num * 10 + (s.charAt(j) - '0');
                    j++;
                }
                stack.push(num);
                i = j - 1;
            } else {
                while (!ops.isEmpty() && prec.get(ops.peek()) >= prec.get(s.charAt(i))) {
                    oper(stack, ops.pop());
                }
                ops.push(s.charAt(i));
            }
        }
        
        while (stack.size() > 1) {
            oper(stack, ops.pop());
        }
        
        return stack.peek();
    }
    
    private void oper(Deque<Integer> stack, char ch) {
        int n2 = stack.pop(), n1 = stack.pop();
        stack.push(calc(n1, n2, ch));
    }
    
    private int calc(int a, int b, char ch) {
        switch (ch) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b;
        }
        
        return 0;
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().calculate("1 + 1 * 3 / (3 - 1)"));
        // System.out.println(new Solution().calculate(" 2 - 1 +  2"));
        System.out.println(new Solution().calculate("(2+ (1 + 3) - 3)"));
    }
}
