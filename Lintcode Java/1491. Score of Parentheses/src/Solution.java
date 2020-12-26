import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    /**
     * @param S: a string
     * @return: the score of the string
     */
    public int scoreOfParentheses(String S) {
        // Write your code here
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (ch == '(') {
                stack.push(-1);
            } else {
                int tmp = 0;
                while (!stack.isEmpty() && stack.peek() != -1) {
                    tmp += stack.pop();
                }
                
                stack.pop();
                if (tmp == 0) {
                    stack.push(1);
                } else {
                    stack.push(tmp * 2);
                }
            }
        }
        
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().scoreOfParentheses("(())"));
    }
}
