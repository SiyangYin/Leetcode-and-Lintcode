import java.util.Stack;

public class Solution {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0, last = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty()) {
                int left = stack.peek();
                if (height[left] <= height[i]) {
                    sum += Math.max(height[left] - last, 0) * (i - left - 1);
                    if (!stack.isEmpty()) {
                        last = height[stack.pop()];
                    }
                } else {
                    sum += Math.max(height[i] - last, 0) * (i - left - 1);
                    break;
                }
            }
            stack.push(i);
        }
        
        return sum;
    }
    
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        height = new int[]{4, 0, 4};
        System.out.println(new Solution().trap(height));
    }
}
