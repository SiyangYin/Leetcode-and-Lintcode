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
        
        return Math.max(res, vol);
    }
    
    public static int trap2(int[] height) {
        int n = height.length;
        int[] dpl = new int[n], dpr = new int[n];
        for (int i = 1; i < n; i++) {
            dpl[i] = Math.max(dpl[i - 1], height[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            dpr[i] = Math.max(dpr[i + 1], height[i + 1]);
        }
        
        int res = 0, vol = 0;
        for (int i = 0; i < n; i++) {
            int w = Math.min(dpl[i], dpr[i]) - height[i];
            vol += Math.max(0, w);
            
            if (w <= 0) {
                res = Math.max(res, vol);
                vol = 0;
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[] height = {1, 0, 2, 1, 0, 1, 8, 2, 9};
        // int[] height = {2, 0, 1, 0};
        System.out.println(trap(height));
        System.out.println(trap2(height));
    }
}