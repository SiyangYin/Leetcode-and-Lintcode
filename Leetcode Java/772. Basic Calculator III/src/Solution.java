import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int calculate(String s) {
        Map<Character, Integer> prio = new HashMap<>();
        prio.put('(', 1);
        prio.put('+', 2);
        prio.put('-', 2);
        prio.put('*', 3);
        prio.put('/', 3);
        
        Deque<Character> ops = new ArrayDeque<>();
        Deque<Long> stack = new ArrayDeque<>();
        
        for (int i = 0; i < s.length(); i++) {
            System.out.println(ops);
            char ch = s.charAt(i);
            if (ch == '(') {
                ops.push('(');
            } else if (Character.isDigit(ch)) {
                int j = i;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    j++;
                }
                
                stack.push(Long.parseLong(s.substring(i, j)));
                i = j - 1;
            } else if (ch == ')') {
                while (ops.peek() != '(') {
                    calc(stack, ops);
                }
                ops.pop();
            } else if (ch != ' ') {
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
        Deque<Integer> s = new ArrayDeque<>();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s);
        System.out.println(s.peekFirst());
        System.out.println(s.peekLast());
        System.out.println(new Solution().calculate(" 6-4 / 2"));
    }
}
