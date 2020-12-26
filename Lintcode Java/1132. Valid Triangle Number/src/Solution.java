import java.util.Arrays;

public class Solution {
    /**
     * @param nums: the given array
     * @return:  the number of triplets chosen from the array that can make triangles
     */
    public int triangleNumber(int[] nums) {
        // Write your code here
        if (nums.length < 3) {
            return 0;
        }
        
        int res = 0;
        Arrays.sort(nums);
        for (int i = 2; i < nums.length; i++) {
            int l = 0, r = i - 1;
            while (l < r) {
                int sum = nums[l] + nums[r];
                if (sum > nums[i]) {
                    res += r - l;
                    r--;
                } else {
                    l++;
                }
            }
        }
        
        return res;
    }
}
