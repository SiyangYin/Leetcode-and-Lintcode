public class Solution {
    public int splitArray(int[] nums, int m) {
        int l = 0, r = 0;
        for (int i = 0; i < nums.length; i++) {
            l = Math.max(l, nums[i]);
            r += nums[i];
        }
        
        while (l < r) {
            int mid = l + (r - l >> 1);
            if (partition(nums, mid) <= m) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        
        return l;
    }
    
    private int partition(int[] nums, int x) {
        int count = 0, sum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > x) {
                sum = 0;
                i--;
                count++;
            }
        }
        
        return count + 1;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().splitArray(new int[]{7, 2, 5, 10, 8}, 2));
    }
}
