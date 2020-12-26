import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
    
        Deque<Integer> stack = new ArrayDeque<>();
        int len = nums.length;
        int[] res = new int[len];
        Arrays.fill(res, -1);
        for (int i = 0; i < 2 * len - 1; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % len]) {
                res[stack.pop()] = nums[i % len];
            }
            stack.push(i % len);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().nextGreaterElements(new int[]{1, 2, 1})));
    }
}
