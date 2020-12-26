public class Solution {
    /**
     * @param nums: The integer array you should partition
     * @param k: An integer
     * @return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int i = 0, j = nums.length - 1;
        int tmp = nums[j];
        while (i < j) {
            while (i < j && nums[i] < k) {
                i++;
            }
            nums[j] = nums[i];
            while (i < j && nums[j] >= k) {
                j--;
            }
            nums[i] = nums[j];
        }
        nums[i] = tmp;
        return binarySearch(nums, i, nums.length - 1, k);
    }
    
    private int binarySearch(int[] nums, int l, int r, int k) {
        while (l < r) {
            int m = l + (r - l >> 1);
            if (nums[m] < k) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        
        return nums[l] >= k ? l : l + 1;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().partitionArray(new int[]{9,9,9,8,9,8,7,9,8,8,8,9,8,9,8,8,6,9}, 9));
        System.out.println(new Solution().partitionArray(new int[]{3, 2, 2, 1}, 2));
        System.out.println(new Solution().partitionArray(new int[]{3, 2, 1}, 2));
    }
}