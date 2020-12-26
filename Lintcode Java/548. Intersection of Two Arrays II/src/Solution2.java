import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
    /**
     * @param nums1: an integer array
     * @param nums2: an integer array
     * @return: an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        // write your code here
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
    
        if (nums1.length > nums2.length) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }
    
        Arrays.sort(nums1);
        Arrays.sort(nums2);
    
        int start = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            int pos = binarySearch(nums2, start, nums2.length - 1, nums1[i]);
            if (pos != -1) {
                res.add(nums1[i]);
                start = pos + 1;
                if (start == nums2.length) {
                    break;
                }
            }
        }
        
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
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
        
        return nums[l] == k ? l : -1;
    }
    
}
