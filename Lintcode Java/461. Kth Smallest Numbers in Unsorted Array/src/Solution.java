public class Solution {
    /**
     * @param k: An integer
     * @param nums: An integer array
     * @return: kth smallest element
     */
    public int kthSmallest(int k, int[] nums) {
        // write your code here
        int l = 0, r = nums.length - 1, pos = 0;
        while ((pos = partition(nums, l, r)) != k - 1) {
            if (pos < k - 1) {
                l = pos + 1;
            } else {
                r = pos - 1;
            }
        }
        
        return nums[pos];
    }
    
    private int partition(int[] nums, int l, int r) {
        int m = l + (r - l >> 1);
        swap(nums, l, m);
        int pivot = nums[l];
        
        int i = l, j = r;
        while (i < j) {
            while (i < j && pivot <= nums[j]) {
                j--;
            }
            nums[i] = nums[j];
            while (i < j && nums[i] <= pivot) {
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = pivot;
        return i;
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().kthSmallest(3, new int[]{3, 4, 1, 2, 5}));
    }
}
