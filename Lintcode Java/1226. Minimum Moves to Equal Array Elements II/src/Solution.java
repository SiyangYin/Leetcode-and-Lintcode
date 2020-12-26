public class Solution {
    /**
     * @param nums: an array
     * @return: the minimum number of moves required to make all array elements equal
     */
    public int minMoves2(int[] nums) {
        // Write your code here
        partition(nums, 0, nums.length - 1, nums.length / 2);
        
        int res = 0;
        for (int num : nums) {
            res += Math.abs(num - nums[nums.length / 2]);
        }
        
        return res;
    }
    
    private void partition(int[] nums, int l, int r, int mid) {
        if (l >= r) {
            return;
        }
        
        swap(nums, l, l + (r - l >> 1));
        int pivot = nums[l], left = l, right = r;
        
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
        
        if (l < mid) {
            partition(nums, l + 1, right, mid);
        } else if (l > mid) {
            partition(nums, left, l - 1, mid);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().minMoves2(new int[]{1, 2, 5, 8, 0}));
    }
}
