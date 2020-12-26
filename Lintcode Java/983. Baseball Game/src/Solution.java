import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    /**
     * @param ops: the list of operations
     * @return:  the sum of the points you could get in all the rounds
     */
    public int calPoints(String[] ops) {
        // Write your code here
        Deque<Integer> stack = new ArrayDeque<>();
        for (String op : ops) {
            if (op.equals("C")) {
                stack.pop();
            } else if (op.equals("D")) {
                stack.push(2 * stack.peek());
            } else if (op.equals("+")) {
                int top = stack.pop(), next = stack.peek() + top;
                stack.push(top);
                stack.push(next);
            } else {
                stack.push(Integer.parseInt(op));
            }
        }
        
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        String[] ops = {"5", "2", "C", "D", "+"};
        System.out.println(new Solution().calPoints(ops));
    }
}
