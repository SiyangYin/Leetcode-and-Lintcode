public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the middle number of the array
     */
    public int median(int[] nums) {
        // write your code here
        int k = nums.length / 2;
        if (nums.length % 2 == 0) {
            k -= 1;
        }
        
        int pos = 0, l = 0, r = nums.length - 1;
        while ((pos = partition(nums, l, r)) != k) {
            if (pos < k) {
                l = pos + 1;
            } else {
                r = pos - 1;
            }
        }
        
        return nums[k];
    }
    
    private int partition(int[] nums, int l, int r) {
        int mid = l + (r - l >> 1);
        int tmp = nums[l];
        nums[l] = nums[mid];
        nums[mid] = tmp;
        
        int pivot = nums[l];
        
        while (l < r) {
            while (l < r && nums[r] >= pivot) {
                r--;
            }
            nums[l] = nums[r];
            while (l < r && nums[l] <= pivot) {
                l++;
            }
            nums[r] = nums[l];
        }
        nums[l] = pivot;
        
        return l;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().median(new int[]{7, 9, 4, 5}));
    }
}
