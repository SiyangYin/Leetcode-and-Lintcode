import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    /**
     * @param s: an expression includes numbers, letters and brackets
     * @return: a string
     */
    public String expressionExpand(String s) {
        // write your code here
        Deque<String> stringStack = new ArrayDeque<>();
        Deque<Integer> numStack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                int j = i + 1;
                while (j < s.length() && Character.isLetter(s.charAt(j))) {
                    j++;
                }
                stringStack.push(s.substring(i, j));
                i = j - 1;
            } else if (Character.isDigit(s.charAt(i))) {
                int j = i + 1;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    j++;
                }
                numStack.push(Integer.parseInt(s.substring(i, j)));
                i = j - 1;
            } else if (s.charAt(i) == '[') {
                stringStack.push("[");
            } else {
                StringBuilder sb = new StringBuilder();
                while (!"[".equals(stringStack.peek())) {
                    sb.append(new StringBuilder(stringStack.pop()).reverse());
                }
                stringStack.pop();
                stringStack.push(sb.reverse().toString().repeat(numStack.pop()));
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while (!stringStack.isEmpty()) {
            sb.append(stringStack.pollLast());
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().expressionExpand("abc3[a]"));
        System.out.println(new Solution().expressionExpand("3[2[ad]3[pf]]xyz"));
        // System.out.println(new Solution().expressionExpand("5[10[abcd]Ac20[abcde]]"));
        // System.out.println("a".repeat(0));
        
        // System.out.println(new Solution().expressionExpand("2[0[ab]5[0[abc]xy]uw]1[k]7[17[5[a]bcd]eok]1[haha]2[heihie]4[nihao]3[12[bc]4[t]]"));
        
    }
}
