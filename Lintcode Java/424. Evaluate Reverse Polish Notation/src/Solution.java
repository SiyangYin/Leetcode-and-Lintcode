import java.util.*;

public class Solution {
    /**
     * @param tokens: The Reverse Polish Notation
     * @return: the value
     */
    public int evalRPN(String[] tokens) {
        // write your code here
        Deque<Integer> stack = new LinkedList<>();
        Set<String> operators = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
        for (int i = 0; i < tokens.length; i++) {
            if (!operators.contains(tokens[i])) {
                stack.push(Integer.parseInt(tokens[i]));
            } else {
                int b = stack.pop(), a= stack.pop();
                stack.push(cal(a, b, tokens[i]));
            }
        }
        
        return stack.peek();
    }
    
    private int cal(int a, int b, String op) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b;
            default: return 0;
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().evalRPN(new String[]{"2", "1", "+", "3", "*"}));
    }
}
