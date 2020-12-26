import java.util.*;

public class Solution {
    /**
     * @param expression: A string array
     * @return: The Reverse Polish notation of this expression
     */
    public List<String> convertToRPN(String[] expression) {
        // write your code here
        List<String> res = new ArrayList<>();
        Map<String, Integer> prec = new HashMap<>();
        prec.put("(", 1);
        prec.put("+", 2);
        prec.put("-", 2);
        prec.put("*", 3);
        prec.put("/", 3);
        Deque<String> stack = new ArrayDeque<>();
        for (String s : expression) {
            if (!prec.containsKey(s) && !")".equals(s)) {
                res.add(s);
            } else if ("(".equals(s)) {
                stack.push(s);
            } else if (")".equals(s)) {
                while (!"(".equals(stack.peek())) {
                    res.add(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && prec.get(stack.peek()) >= prec.get(s)) {
                    res.add(stack.pop());
                }
                stack.push(s);
            }
        }
        
        res.addAll(stack);
        return res;
    }
    
    public static void main(String[] args) {
        // String[] exp = {"3", "-", "4", "+", "5"};
        String[] exp = {"(", "5", "-", "6", ")", "*", "7"};
        // String[] exp = {"2", "*", "6", "-", "(", "23", "+", "7", ")", "/", "(", "1", "+", "2", ")"};
        // String[] exp = {"(", "(", "1", "+", "(", "2", ")", ")", "*", "3", "+", "(", "4", "/", "2", ")", "-", "5", ")"};
        System.out.println(new Solution().convertToRPN(exp));
    }
}
