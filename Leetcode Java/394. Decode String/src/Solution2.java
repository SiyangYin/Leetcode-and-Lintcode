import java.util.Deque;
import java.util.LinkedList;

public class Solution2 {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
    
        Deque<Integer> numStack = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int n = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    n *= 10;
                    n += s.charAt(i) - '0';
                    i++;
                }
                numStack.push(n);
            }
            res.append(s.charAt(i));
            if (s.charAt(i) == ']') {
                int lastLeft = res.length() - 1;
                while (res.charAt(lastLeft) != '[') {
                    lastLeft--;
                }
                String lastWord = res.substring(lastLeft + 1, res.length() - 1);
                res.setLength(lastLeft);
                res.append(lastWord.repeat(numStack.pop()));
            }
        }
        
        return res.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution2().decodeString("3[a]2[bc]"));
        System.out.println(new Solution2().decodeString("cc3[a2[c]]"));
        System.out.println(new Solution2().decodeString("2[abc]3[cd]ef"));
        System.out.println(new Solution2().decodeString("10[a]"));
        System.out.println(new Solution2().decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
    }
}
