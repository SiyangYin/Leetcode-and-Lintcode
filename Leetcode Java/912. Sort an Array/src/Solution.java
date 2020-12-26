import java.util.ArrayList;
import java.util.List;

public class Solution {
    
    public static void main(String[] args) {
        System.out.println(new Solution().sortArray(new int[]{5, 1, 1, 2, 0, 0}));
    }
    
    public List<Integer> sortArray(int[] nums) {
        List<Integer> res = new ArrayList<>();
        quickSort(nums, 0, nums.length - 1);
        for (int num : nums) {
            res.add(num);
        }
        return res;
    }
    
    private void quickSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = partition(nums, l, r);
        quickSort(nums, l, mid - 1);
        quickSort(nums, mid + 1, r);
    }
    
    private int partition(int[] nums, int l, int r) {
        swap(nums, l, l + (r - l >> 1));
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
}
