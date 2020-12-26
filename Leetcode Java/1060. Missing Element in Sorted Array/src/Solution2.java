public class Solution2 {
    public int missingElement(int[] nums, int k) {
        // 找左边miss数小于等于k的最大的数
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l + 1 >> 1);
            // System.out.println(missCount(nums, m));
            if (missCount(nums, m) <= k - 1) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        
        return nums[l] + k - missCount(nums, l);
    }
    
    private int missCount(int[] nums, int i) {
        return nums[i] - nums[0] - i;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution2().missingElement(new int[]{4, 7, 9, 10}, 1));
        System.out.println(new Solution2().missingElement(new int[]{4, 7, 9, 10}, 3));
        System.out.println(new Solution2().missingElement(new int[]{1,2,4}, 3));
    }
}
