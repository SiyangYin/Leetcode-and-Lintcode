import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Character> ops = new ArrayDeque<>();
        Map<Character, Integer> prec = new HashMap<>();
        prec.put('+', 1);
        prec.put('-', 1);
        prec.put('*', 2);
        prec.put('/', 2);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                continue;
            }
            
            if (Character.isDigit(s.charAt(i))) {
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
                    char op = ops.pop();
                    int n2 = stack.pop(), n1 = stack.pop();
                    stack.push(calc(op, n1, n2));
                }
                
                ops.push(s.charAt(i));
            }
        }
        
        while (stack.size() > 1) {
            int n2 = stack.pop(), n1 = stack.pop();
            stack.push(calc(ops.pop(), n1, n2));
        }
        
        return stack.peek();
    }
    
    private int calc(char ch, int a, int b) {
        switch (ch) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b;
        }
        return 0;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().calculate("3+22*2"));
        // System.out.println(new Solution().calculate("32"));
    }
}
