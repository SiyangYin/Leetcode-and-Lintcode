import java.util.*;

public class Solution {
    /**
     * @param expression: A string array
     * @return: The Polish notation of this expression
     */
    public List<String> convertToPN(String[] expression) {
        // write your code here
        List<String> res = new ArrayList<>();
        
        Deque<String> ops = new LinkedList<>();
        Map<String, Integer> prio = new HashMap<>();
        prio.put(")", 1);
        prio.put("+", 2);
        prio.put("-", 2);
        prio.put("*", 3);
        prio.put("/", 3);
        
        for (int i = expression.length - 1; i >= 0; i--) {
            String s = expression[i];
            if (Character.isDigit(s.charAt(0))) {
                res.add(s);
            } else if (s.equals(")")) {
                ops.push(s);
            } else if (s.equals("(")) {
                while (!ops.peek().equals(")")) {
                    res.add(ops.pop());
                }
                
                ops.pop();
            } else {
                while (!ops.isEmpty() && prio.get(ops.peek()) > prio.get(s)) {
                    res.add(ops.pop());
                }
                
                ops.push(s);
            }
        }
        
        res.addAll(ops);
        
        Collections.reverse(res);
        return res;
    }
    
    public static void main(String[] args) {
        String[] ss = {"(", "999", "/", "3", "/", "3", "/", "3", ")", "+", "(", "1", "+", "9", "/", "3", ")"};
        // String[] ss = {"3", "+", "(", "1", "-", "2", ")"};
        System.out.println(new Solution().convertToPN(ss));
    }
}
