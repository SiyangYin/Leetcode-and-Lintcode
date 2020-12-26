import java.util.Arrays;

public class Solution {
    public int triangleNumber(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        
        Arrays.sort(nums);
        int res = 0;
        for (int i = 2; i < nums.length; i++) {
            int l = 0, r = i - 1;
            while (l < r) {
                if (nums[l] + nums[r] > nums[i]) {
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
