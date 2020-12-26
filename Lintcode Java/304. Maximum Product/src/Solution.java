import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param nums: Unordered array
     * @return: return the largest product
     */
    public long MaximumProduct(int[] nums) {
        // write your code here
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
            if (pos < 1) {
                l = pos + 1;
            } else {
                r = pos - 1;
            }
        }
        
        List<Long> list = new ArrayList<>();
        int i = 0;
        for (i = nums.length - 1; i >= nums.length - 3; i--) {
            list.add((long) nums[i]);
        }
        
        for (int j = 0; j <= Math.min(1, i); j++) {
            list.add((long) nums[j]);
        }
        
        long res = Long.MIN_VALUE;
        for (int j = 0; j < list.size() - 2; j++) {
            for (int k = j + 1; k < list.size() - 1; k++) {
                for (int m = k + 1; m < list.size(); m++) {
                    res = Math.max(res, list.get(j) * list.get(k) * list.get(m));
                }
            }
        }
        
        return res;
    }
    
    private int partition(int[] nums, int l, int r) {
        if (l >= r) {
            return l;
        }
        
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
    
    public static void main(String[] args) {
        // System.out.println(new Solution().MaximumProduct(new int[]{3, 4, 1, 2}));
        // System.out.println(new Solution().MaximumProduct(new int[]{-20, -10, -15, 5, -5, -18, -9, -2, 14, -15}));
        System.out.println(new Solution().MaximumProduct(new int[]{2, -6, -5, 5, -15, 19, -19, -16, 5, -7}));
    }
}
