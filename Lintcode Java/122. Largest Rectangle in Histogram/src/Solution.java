import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] height) {
        // write your code here
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        for (int i = 0; i < height.length; i++) {
            while (stack.peek() != -1 && height[stack.peek()] > height[i]) {
                int top = stack.peek();
                stack.pop();
                res = Math.max(res, height[top] * (i - stack.peek() - 1));
            }
            
            stack.push(i);
        }
        
        while (stack.peek() != -1) {
            int top = stack.peek();
            stack.pop();
            res = Math.max(res, height[top] * (height.length - stack.peek() - 1));
        }
        
        return res;
    }
}
