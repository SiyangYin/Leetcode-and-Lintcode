import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution {
    /**
     * @param temperatures: a list of daily temperatures
     * @return: a list of how many days you would have to wait until a warmer temperature
     */
    public int[] dailyTemperatures(int[] temperatures) {
        // Write your code here
        int[] res = new int[temperatures.length];
        
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                res[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            
            stack.push(i);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }
}
