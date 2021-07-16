import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Solution {
    /**
     * @param expression: a string that representing an expression
     * @return: the result of the expression
     */
    public String evaluation(String expression) {
        // write your code here
        List<String> list = Arrays.asList("true", "false");
        String[] strs = expression.split(" ");
        if (!list.contains(strs[0]) || !list.contains(strs[strs.length - 1])) {
            return "error";
        }
        
        for (int i = 1; i < strs.length; i++) {
            if (list.contains(strs[i]) == list.contains(strs[i - 1])) {
                return "error";
            }
        }
    
        Deque<Boolean> stk = new ArrayDeque<>();
        for (int i = 0; i < strs.length; i++) {
            if (list.contains(strs[i])) {
                stk.push("true".equals(strs[i]));
            } else {
                if ("and".equals(strs[i])) {
                    stk.push(stk.pop() && "true".equals(strs[i + 1]));
                    i++;
                }
            }
        }
        
        while (!stk.isEmpty()) {
            if (stk.pop()) {
                return "true";
            }
        }
        
        return "false";
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().evaluation("false and"));
        System.out.println(new Solution().evaluation("true and false"));
    }
}
