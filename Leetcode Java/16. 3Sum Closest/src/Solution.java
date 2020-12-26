import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (Math.abs(res - target) > Math.abs(sum - target)) {
                    res = sum;
                }
                
                if (sum < target) {
                    l++;
                } else if (sum > target) {
                    r--;
                } else {
                    return target;
                }
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        System.out.println(new Solution().threeSumClosest(nums, 1));
    }
}
