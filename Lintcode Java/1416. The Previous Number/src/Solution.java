import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution {
    /**
     * @param num: The arry you should handle
     * @return: Return the array
     */
    public int[] getPreviousNumber(int[] num) {
        // Write your code here
        int[] res = new int[num.length];
        
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < num.length; i++) {
            while (!stack.isEmpty() && stack.peek() >= num[i]) {
                stack.pop();
            }
            
            if (!stack.isEmpty()) {
                res[i] = stack.peek();
            } else {
                res[i] = num[i];
            }
            
            stack.push(num[i]);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().getPreviousNumber(new int[]{2, 3, 6, 1, 5, 5})));
    }
}
