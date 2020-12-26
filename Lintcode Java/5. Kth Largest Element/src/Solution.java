public class Solution {
    /**
     * @param n: An integer
     * @param nums: An array
     * @return: the Kth largest element
     */
    public int kthLargestElement(int n, int[] nums) {
        // write your code here
        int l = 0, r = nums.length - 1;
        int k = 0;
        while ((k = partition(nums, l, r)) != nums.length - n) {
            if (k < nums.length - n) {
                l = k + 1;
            } else {
                r = k - 1;
            }
        }
        return nums[k];
    }
    
    private int partition(int[] arr, int l, int r) {
        int m = l + (r - l >> 1);
        swap(arr, l, m);
        
        int i = l, j = r;
        int pivot = arr[i];
        while (i < j) {
            while (arr[j] >= pivot && j > i) {
                j--;
            }
            arr[i] = arr[j];
            while (arr[i] <= pivot && j > i) {
                i++;
            }
            arr[j] = arr[i];
        }
        arr[i] = pivot;
        return i;
    }
    
    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    
    public static void main(String[] args) {
        int[] nums = new int[]{9, 3, 2, 4, 8};
        System.out.println(new Solution().kthLargestElement(3, nums));
    }
}