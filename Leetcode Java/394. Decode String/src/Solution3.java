import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Solution3 {
    public String decodeString(String s) {
        StringBuilder sb1 = new StringBuilder();
        Deque<String> stack1 = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != ']') {
                stack1.push(String.valueOf(s.charAt(i)));
            }
            else {
                Deque<String> stack2 = new ArrayDeque<>();
                Deque<String> stack3 = new ArrayDeque<>();
                while (!stack1.peek().equals("[")) {
                    stack2.push(stack1.pop());
                }
                stack1.pop();
                StringBuilder sb2 = new StringBuilder();
                StringBuilder sb3 = new StringBuilder();
                while (!stack2.isEmpty()) {
                    sb3.append(stack2.pop());
                }
                while (!stack1.isEmpty() && Character.isDigit(stack1.peek().charAt(0))) {
                    stack3.push(stack1.pop());
                }
                int j = 0;
                while (!stack3.isEmpty()) {
                    j = j * 10 + Integer.parseInt(stack3.pop());
                }
                for (int k = 0; k < j; k++) {
                    sb2.append(sb3);
                }
                stack1.push(sb2.toString());
            }
        }
        while (!stack1.isEmpty()) {
            sb1.append(stack1.pollLast());
        }
        return sb1.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution3().decodeString("3[a]2[bc]"));
        System.out.println(new Solution3().decodeString("cc3[a2[c]]"));
        System.out.println(new Solution3().decodeString("2[abc]3[cd]ef"));
        System.out.println(new Solution3().decodeString("10[a]"));
        System.out.println(new Solution3().decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
    }
}
