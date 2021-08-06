import java.util.Arrays;

public class Solution {
    public long countPairs(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = nums1[i] - nums2[i];
        }
    
        Arrays.sort(diff);
        
        long res = 0;
        int l = 0, r = n - 1;
        while (l < r) {
            if (diff[l] + diff[r] <= 0) {
                l++;
            } else {
                res += r - l;
                r--;
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[] A = {1, 10, 6, 2}, B = {1, 4, 1, 5};
        System.out.println(new Solution().countPairs(A, B));
    }
}
