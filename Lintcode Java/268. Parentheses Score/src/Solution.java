import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    /**
     * @param S: a string with "(" and ")"
     * @return: return the score of the string
     */
    public int ParenthesesScore(String S) {
        // write your code here
        Deque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (ch == '(') {
                stack.push(String.valueOf(ch));
            } else {
                if ("(".equals(stack.peek())) {
                    stack.pop();
                    stack.push("1");
                } else {
                    int num = 0;
                    while (!"(".equals(stack.peek())) {
                        num += Integer.parseInt(stack.pop());
                    }
                    
                    stack.pop();
                    stack.push(String.valueOf(num * 2));
                }
            }
        }
        
        int res = 0;
        while (!stack.isEmpty()) {
            res += Integer.parseInt(stack.pop());
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().ParenthesesScore("(()(()))"));
    }
}
