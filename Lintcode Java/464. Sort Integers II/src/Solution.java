import java.util.Arrays;

public class Solution {
    /**
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers2(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return;
        }
        
        quickSort(A, 0, A.length - 1);
    }
    
    public void quickSort(int[] nums, int l, int r) {
        int start = l, end = r;
        if (l >= r) {
            return;
        }
        
        while (l < r) {
            while (l < r && nums[r] >= nums[l]) {
                r--;
            }
            swap(nums, l, r);
            
            while (l < r && nums[l] <= nums[r]) {
                l++;
            }
            swap(nums, l, r);
        }
        
        quickSort(nums, start, l);
        quickSort(nums, l + 1, end);
    }
    
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    public static void main(String[] args) {
        int[] arr = {3, 2, 1};
        new Solution().sortIntegers2(arr);
        System.out.println(Arrays.toString(arr));
    }
}