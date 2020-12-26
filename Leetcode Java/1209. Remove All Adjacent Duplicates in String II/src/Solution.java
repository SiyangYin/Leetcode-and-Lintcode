import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public String removeDuplicates(String s, int k) {
        if (s == null || s.length() == 0) {
            return s;
        }
        
        StringBuilder sb = new StringBuilder();
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (sb.length() == 0 || s.charAt(i) != sb.charAt(sb.length() - 1)) {
                stack.push(1);
            } else {
                stack.push(stack.pop() + 1);
            }
            sb.append(s.charAt(i));
            
            if (stack.peek() == k) {
                sb.setLength(sb.length() - k);
                stack.pop();
            }
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().removeDuplicates("deeedbbcccbdaa", 3));
        System.out.println(new Solution().removeDuplicates("abcd", 3));
        System.out.println(new Solution().removeDuplicates("pbbcggttciiippooaais", 2));
    }
}
