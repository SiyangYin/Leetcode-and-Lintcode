import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    
    public static void main(String[] args) {
        System.out.println(new Solution2().sortArray(new int[]{5, 2, 3, 1}));
    }
    
    public List<Integer> sortArray(int[] nums) {
        List<Integer> res = new ArrayList<>();
        mergeSort(nums, 0, nums.length - 1, new int[nums.length]);
        for (int num : nums) {
            res.add(num);
        }
        return res;
    }
    
    private void mergeSort(int[] nums, int l, int r, int[] tmp) {
        if (l >= r) {
            return;
        }
        
        int mid = l + ((r - l) >> 1);
        mergeSort(nums, l, mid, tmp);
        mergeSort(nums, mid + 1, r, tmp);
        merge(nums, l, mid, r, tmp);
    }
    
    private void merge(int[] nums, int l, int mid, int r, int[] tmp) {
        int i = l, j = mid + 1, index = 0;
        while (i <= mid && j <= r) {
            if (nums[i] <= nums[j]) {
                tmp[index++] = nums[i++];
            } else {
                tmp[index++] = nums[j++];
            }
        }
        while (i <= mid) {
            tmp[index++] = nums[i++];
        }
        while (j <= r) {
            tmp[index++] = nums[j++];
        }
    
        index = 0;
        for (int k = l; k <= r; k++) {
            nums[k] = tmp[index++];
        }
    }
}
