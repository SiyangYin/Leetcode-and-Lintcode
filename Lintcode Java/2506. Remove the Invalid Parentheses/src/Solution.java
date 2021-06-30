import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    /**
     * @param s: A string with lowercase letters and parentheses
     * @return: A string which has been removed invalid parentheses
     */
    public String removeParentheses(String s) {
        // write your code here.
        char[] chs = s.toCharArray();
        Deque<Integer> stk = new ArrayDeque<>();
        for (int i = 0, cnt = 0; i < chs.length; i++) {
            if (chs[i] == '(') {
                stk.push(i);
                cnt++;
            } else if (chs[i] == ')') {
                if (cnt == 0) {
                    chs[i] = ' ';
                } else {
                    cnt--;
                    stk.pop();
                }
            }
        }
        while (!stk.isEmpty()) {
            chs[stk.pop()] = ' ';
        }
        
        StringBuilder sb = new StringBuilder();
        for (char ch : chs) {
            if (ch != ' ') {
                sb.append(ch);
            }
        }
        
        return sb.toString();
    }
}
