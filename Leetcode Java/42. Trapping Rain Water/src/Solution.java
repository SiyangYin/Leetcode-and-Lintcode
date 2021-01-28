import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int trap(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;
    
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int top = stack.pop();
                if (!stack.isEmpty()) {
                    res += (Math.min(height[stack.peek()], height[i]) - height[top]) * (i - stack.peek() - 1);
                }
            }
            
            stack.push(i);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        // height = new int[]{4, 0, 4};
        System.out.println(new Solution().trap(height));
    }
}
