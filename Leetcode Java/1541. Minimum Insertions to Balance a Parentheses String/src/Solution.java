import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int minInsertions(String s) {
        Deque<Character> stk = new ArrayDeque<>();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stk.push(ch);
            } else {
                if (i < s.length() - 1 && s.charAt(i + 1) == ')') {
                    if (stk.isEmpty()) {
                        res++;
                    } else {
                        stk.pop();
                    }
                    
                    i++;
                } else {
                    if (stk.isEmpty()) {
                        res += 2;
                    } else {
                        stk.pop();
                        res++;
                    }
                }
            }
        }
        
        return res + stk.size() * 2;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().minInsertions("(()))(()))()())))"));
        System.out.println(new Solution().minInsertions(")))))))"));
        System.out.println(new Solution().minInsertions("))())("));
    }
}
