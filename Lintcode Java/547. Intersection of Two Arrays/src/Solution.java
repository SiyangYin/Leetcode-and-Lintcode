import java.util.HashSet;
import java.util.Set;

public class Solution {
    /**
     * @param nums1: an integer array
     * @param nums2: an integer array
     * @return: an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        // write your code here
        Set<Integer> set = new HashSet<>();
        int[] shorter = nums1.length <= nums2.length ? nums1 : nums2, longer = nums1 == shorter ? nums2 : nums1;
        for (int num : shorter) {
            set.add(num);
        }
        Set<Integer> intersection = new HashSet<>();
        for (int num : longer) {
            if (set.contains(num)) {
                intersection.add(num);
            }
        }
        
        int[] res = new int[intersection.size()];
        int ind = 0;
        for (int num : intersection) {
            res[ind++] = num;
        }
        
        return res;
    }
}
