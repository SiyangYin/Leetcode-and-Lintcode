import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Solution3 {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int area = 0;
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                int height = heights[stack.pop()];
                int j = !stack.isEmpty() ? stack.peek() : -1;
                area = Math.max(area, (i - 1 - j) * height);
            }
            stack.push(i);
        }
        int i = heights.length;
        while (!stack.isEmpty()) {
            int height = heights[stack.pop()];
            int j = !stack.isEmpty() ? stack.peek() : -1;
            area = Math.max(area, (i - 1 - j) * height);
        }
        return area;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution3().largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(new Solution3().largestRectangleArea(new int[]{2, 1, 2}));
        System.out.println(new Solution3().largestRectangleArea(new int[]{5, 4, 1, 2}));
    }
}
