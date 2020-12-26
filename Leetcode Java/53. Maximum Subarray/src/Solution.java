class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int maxSum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (sum >= 0) {
                sum += nums[i];
            }
            else {
                sum = nums[i];
            }
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
        return maxSum;
    }
    
    public int maxSubArray2(int[] nums) {
        return maxSub(nums, 0, nums.length - 1);
    }
    
    public int maxSub(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int mid = left + ((right - left) >> 1);
        int leftsum = maxSub(nums, left, mid);
        int rightsum = maxSub(nums, mid + 1, right);
        int s1 = Integer.MIN_VALUE, lefts = 0;
        for (int i = mid; i >= left; i--) {
            lefts += nums[i];
            if (lefts > s1) {
                s1 = lefts;
            }
        }
        int s2 = Integer.MIN_VALUE, rights = 0;
        for (int i = mid + 1; i <= right; i++) {
            rights += nums[i];
            if (rights > s2) {
                s2 = rights;
            }
        }
        int sum = s1 + s2;
        if (sum < leftsum) {
            sum = leftsum;
        }
        if (sum < rightsum) {
            sum = rightsum;
        }
        return sum;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().maxSubArray2(
                new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(new Solution().maxSubArray2(
                new int[]{-2, -1}));
        
        
        
    }
}