import java.util.Deque;
import java.util.LinkedList;

public class Solution2 {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        
        int res = 0;
        
        // 维护单调递增的栈
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                int top = stack.pop();
                res = Math.max(res, (i - stack.peek() - 1) * heights[top]);
            }
            
            stack.push(i);
        }
        
        while (stack.peek() != -1) {
            int top = stack.pop();
            res = Math.max(res, (heights.length - 1 - stack.peek()) * heights[top]);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution2().largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(new Solution2().largestRectangleArea(new int[]{2, 1, 2}));
        System.out.println(new Solution2().largestRectangleArea(new int[]{5, 4, 1, 2}));
    }
}
