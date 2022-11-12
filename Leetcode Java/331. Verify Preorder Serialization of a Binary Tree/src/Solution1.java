import java.util.ArrayDeque;
import java.util.Deque;

public class Solution1 {
    public boolean isValidSerialization(String preorder) {
        String[] arr = preorder.split(",");
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for (String s : arr) {
            if (!s.equals("#")) {
                if (!stack.isEmpty() && stack.peek() < 2) {
                    stack.push(stack.pop() + 1);
                    stack.push(0);
                }
            }
            else {
                if (!stack.isEmpty()) {
                    stack.push(stack.pop() + 1);
                }
            }
            while (!stack.isEmpty() && stack.peek() >= 2) {
                stack.pop();
            }
        }
        return stack.size() == 1;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution1().isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
        System.out.println(new Solution1().isValidSerialization("1,#"));
    }
}
