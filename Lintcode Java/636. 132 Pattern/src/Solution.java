import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    /**
     * @param nums: a list of n integers
     * @return: true if there is a 132 pattern or false
     */
    public boolean find132pattern(int[] nums) {
        // write your code here
        reverse(nums);
        Deque<Integer> stk = new ArrayDeque<>();
        int left = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (left > nums[i]) {
                return true;
            }
            
            while (!stk.isEmpty() && stk.peek() < nums[i]) {
                left = Math.max(left, stk.pop());
            }
            
            stk.push(nums[i]);
        }
        
        return false;
    }
    
    private void reverse(int[] A) {
        for (int i = 0, j = A.length - 1; i < j; i++, j--) {
            int tmp = A[i];
            A[i] = A[j];
            A[j] = tmp;
        }
    }
    
    public static void main(String[] args) {
        // int[] A = {1, 2, 3, 4};
        int[] A = {3, 1, 4, 2};
        System.out.println(new Solution().find132pattern(A));
    }
}
