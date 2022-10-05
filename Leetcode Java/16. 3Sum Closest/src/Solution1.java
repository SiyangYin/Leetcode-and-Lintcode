import java.util.Arrays;

class Solution1 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int subTarget = target - nums[i];
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                if(Math.abs(nums[j] + nums[k] - subTarget) < min) {
                    min = Math.abs(nums[j] + nums[k] - subTarget);
                    res = nums[i] + nums[j] + nums[k];
                }
                if (nums[j] + nums[k] < subTarget) {
                    j++;
                }
                else if (nums[j] + nums[k] > subTarget) {
                    k--;
                }
                else {
                    return target;
                }
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        System.out.println(new Solution1().threeSumClosest(nums, 1));
    }
}
