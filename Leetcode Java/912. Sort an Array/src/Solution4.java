import java.util.ArrayList;
import java.util.List;

public class Solution4 {
    public List<Integer> sortArray(int[] nums) {
        heapSort(nums);
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            res.add(num);
        }
        return res;
    }
    
    private void heapSort(int[] nums) {
        heapify(nums, nums.length);
        for (int i = nums.length - 1; i >= 0; i--) {
            swap(nums, 0, i);
            percolateDown(nums, i, 0);
        }
    }
    
    private void heapify(int[] nums, int n) {
        for (int i = (n - 1) >> 1; i >= 0; i--) {
            percolateDown(nums, n, i);
        }
    }
    
    private void percolateDown(int[] nums, int n, int i) {
        while ((i << 1) + 1 < n) {
            int child = (i << 1) + 1;
            if ((i << 1) + 2 < n && nums[(i << 1) + 2] > nums[child]) {
                child++;
            }
            if (nums[i] >= nums[child]) {
                break;
            }
            swap(nums, i, child);
            i = child;
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
