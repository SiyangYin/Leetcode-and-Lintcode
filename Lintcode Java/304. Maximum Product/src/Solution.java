import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * @param nums: Unordered array
     * @return: return the largest product
     */
    public long MaximumProduct(int[] nums) {
        // write your code here
        long res = 0;
        
        int l = 0, r = nums.length - 1, pos = 0;
        while ((pos = partition(nums, l, r)) != nums.length - 3) {
            if (pos < nums.length - 3) {
                l = pos + 1;
            } else {
                r = pos - 1;
            }
        }
        l = 0;
        r = nums.length - 1;
        while ((pos = partition(nums, l, r)) != 1) {
            if (pos < nums.length - 3) {
                l = pos + 1;
            } else {
                r = pos - 1;
            }
        }
    
        List<Integer> list = new ArrayList<>();
        int i = 0;
        for (i = nums.length - 1; i >= nums.length - 3; i--) {
            list.add(nums[i]);
        }
    
        for (int j = 0; j < list.size(); j++) {
        
        }
        return res;
    }
    
    private int partition(int[] nums, int i, int j) {
        int pivot = nums[i];
        while (i < j) {
            while (i < j && nums[i] <= nums[j]) {
                j--;
            }
            nums[i] = nums[j];
            while (i < j && nums[i] <= nums[j]) {
                i++;
            }
            nums[j] = nums[i];
        }
        
        nums[i] = pivot;
        return i;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().MaximumProduct(new int[]{3, 4, 1, 2}));
    }
}
