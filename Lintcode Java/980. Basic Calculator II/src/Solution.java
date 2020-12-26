import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * @param s: the given expression
     * @return: the result of expression
     */
    public int calculate(String s) {
        // Write your code here
        Map<Character, Integer> prio = new HashMap<>();
        prio.put('+', 2);
        prio.put('-', 2);
        prio.put('*', 3);
        prio.put('/', 3);
        
        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Character> ops = new ArrayDeque<>();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                continue;
            }
            
            if (Character.isDigit(ch)) {
                int j = i;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    j++;
                }
                stack.push(Integer.parseInt(s.substring(i, j)));
                i = j - 1;
            } else {
                while (!ops.isEmpty() && prio.get(ops.peek()) >= prio.get(ch)) {
                    calc(stack, ops);
                }
                
                ops.push(ch);
            }
        }
        
        while (stack.size() >= 2) {
            calc(stack, ops);
        }
        
        return stack.peek();
    }
    
    private void calc(Deque<Integer> stack, Deque<Character> ops) {
        int n2 = stack.pop(), n1 = stack.pop();
        switch (ops.pop()) {
            case '+': stack.push(n1 + n2); break;
            case '-': stack.push(n1 - n2); break;
            case '*': stack.push(n1 * n2); break;
            case '/': stack.push(n1 / n2); break;
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().calculate("3+2*2"));
    }
}
