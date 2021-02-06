import java.util.ArrayDeque;
import java.util.Deque;

public class Solution3 {
    public static int trap(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        int n = height.length;
        int vol = 0;
        stack.push(-1);
        for (int i = 0; i < n; i++) {
            while (stack.size() > 1 && height[stack.peek()] <= height[i]) {
                int top = stack.pop();
                int a = i - stack.peek() - 1;
                int b = Math.min(height[i], stack.size() == 1 ? 0 : height[stack.peek()]) - height[top];
                vol += Math.max(0, a * b);
            }
            
            if (stack.size() == 1) {
                res = Math.max(res, vol);
                vol = 0;
            }
            
            stack.push(i);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 3, 1, 0, 1, 3};
        System.out.println(trap(height));
    }
}