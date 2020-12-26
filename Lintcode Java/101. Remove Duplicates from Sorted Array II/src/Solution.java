import java.util.Arrays;

public class Solution {
    /**
     * @param nums: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0;
        boolean flag = false;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] == nums[i]) {
                if (!flag) {
                    nums[++i] = nums[j];
                    flag = true;
                } else {
                    continue;
                }
            } else {
                nums[++i] = nums[j];
                flag = false;
            }
        }
        
//        System.out.println(Arrays.toString(nums));
        return i + 1;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().removeDuplicates(new int[]{-14,-14,-14,
                -14,-14,-14,-14,-13,-13,-13,-13,-12,-11,-11,-11,-9,-9,-9,-7}));
    }
    
}
