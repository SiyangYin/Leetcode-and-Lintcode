import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * @param expression: a list of strings
     * @return: an integer
     */
    public int evaluateExpression(String[] expression) {
        // write your code here
        if (expression == null || expression.length == 0) {
            return 0;
        }
        
        Deque<String> ops = new ArrayDeque<>();
        Deque<Integer> nums = new ArrayDeque<>();
        Map<String, Integer> prec = new HashMap<>();
        prec.put("(", 1);
        prec.put("+", 2);
        prec.put("-", 2);
        prec.put("*", 3);
        prec.put("/", 3);
        
        for (String s : expression) {
            if (!prec.containsKey(s) && !")".equals(s)) {
                nums.push(Integer.parseInt(s));
            } else if ("(".equals(s)) {
                ops.push(s);
            } else if (")".equals(s)) {
                while (!"(".equals(ops.peek())) {
                    int n2 = nums.pop(), n1 = nums.pop();
                    nums.push(calc(n1, n2, ops.pop()));
                }
                ops.pop();
            } else {
                while (!ops.isEmpty() && prec.get(ops.peek()) >= prec.get(s)) {
                    int n2 = nums.pop(), n1 = nums.pop();
                    nums.push(calc(n1, n2, ops.pop()));
                }
                ops.push(s);
            }
        }
        
        while (nums.size() > 1) {
            int n2 = nums.pop(), n1 = nums.pop();
            nums.push(calc(n1, n2, ops.pop()));
        }
        
        return nums.isEmpty() ? 0 : nums.peek();
    }
    
    private int calc(int n1, int n2, String op) {
        switch (op) {
            case "+": return n1 + n2;
            case "-": return n1 - n2;
            case "*": return n1 * n2;
            case "/": return n1 / n2;
            default: return 0;
        }
    }
    
    public static void main(String[] args) {
        String s = "2 * 6 - ( 23 + 7 ) / ( 1 + 2 )";
        System.out.println(new Solution().evaluateExpression(s.split(" ")));
    }
}
