import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Set<String> operators = new HashSet<>();
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");
        for (String token : tokens) {
            if (operators.contains(token)) {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                stack.push(operation(operand1, operand2, token));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        
        return stack.pop();
    }
    
    private int operation(int a,int b, String op) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b;
        }
        
        return 0;
    }
    
    public static void main(String[] args) {
        String[] tokens = {"4", "13", "5", "/", "+"};
        System.out.println(new Solution().evalRPN(tokens));
    }
}
