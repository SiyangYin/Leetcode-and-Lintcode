import java.util.Arrays;

public class Solution {
    /**
     * @param nums: an array of integers
     * @return: the number of unique integers
     */
    public int deduplication(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        Arrays.sort(nums);
        
        int idx = -1, j = 0;
        while (j < nums.length) {
            if (idx == -1 || nums[j] != nums[idx]) {
                nums[++idx] = nums[j];
            }
            
            j++;
        }
        
        return idx + 1;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().deduplication(new int[]{1, 3, 1, 4, 4, 2}));
    }
}
