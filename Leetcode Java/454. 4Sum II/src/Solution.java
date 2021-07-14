import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : nums3) {
            for (int y : nums4) {
                cnt.put(x + y, cnt.getOrDefault(x + y, 0) + 1);
            }
        }
        
        int res = 0;
        for (int x : nums1) {
            for (int y : nums2) {
                res += cnt.getOrDefault(-(x + y), 0);
            }
        }
        
        return res;
    }
}
