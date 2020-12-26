import java.util.Arrays;

public class Solution {
    /**
     * @param nums:   a list of integer
     * @param target: an integer
     * @return: nothing
     */
    public void MoveTarget(int[] nums, int target) {
        // write your code here
        int i = nums.length - 1, j = i;
        for (; i >= 0; i--) {
            if (nums[i] != target) {
                nums[j--] = nums[i];
            }
        }
        
        while (j >= 0) {
            nums[j--] = target;
        }
    }
    
    public static void main(String[] args) {
        int[] n = {5,1,6,1};
        new Solution().MoveTarget(n,1);
        System.out.println(Arrays.toString(n));
    }
}
