import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution {
    /**
     * @param nums: an array
     * @return: the Next Greater Number for every element
     */
    public int[] nextGreaterElements(int[] nums) {
        // Write your code here
        int[] res = new int[nums.length];
        Deque<Integer> stack = new ArrayDeque<>();
        boolean[] found = new boolean[nums.length];
        for (int i = 0; i < 2 * nums.length - 1; i++) {
            int idx = i % nums.length;
            while (!stack.isEmpty() && nums[stack.peek()] < nums[idx]) {
                int top = stack.pop();
                res[top] = nums[idx];
                found[top] = true;
            }
            
            stack.push(idx);
        }
    
        for (int i = 0; i < found.length; i++) {
            if (!found[i]) {
                res[i] = -1;
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().nextGreaterElements(new int[]{1, 2, 1})));
    }
}
