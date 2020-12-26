public class Solution {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length + 1 - k;
        int l = 0, r = nums.length - 1;
        int rank = 0;
        while ((rank = partition(nums, l, r)) != k - 1) {
            if (rank < k - 1) {
                l = rank + 1;
            } else {
                r = rank - 1;
            }
        }
        
        return nums[rank];
    }
    
    private int partition(int[] nums, int l, int r) {
        if (l == r) {
            return l;
        }
        swap(nums, l, l + ((r - l) >> 1));
        int pivot = nums[l];
        while (l < r) {
            while (l < r && pivot <= nums[r]) {
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
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().findKthLargest(new int[]{9, 3, 2, 4, 8}, 3));
        
    }
}