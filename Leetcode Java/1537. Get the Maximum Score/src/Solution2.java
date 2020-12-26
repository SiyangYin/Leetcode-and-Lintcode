public class Solution2 {
    public int maxSum(int[] nums1, int[] nums2) {
        int MOD = (int) (1e9 + 7);
        long dp1 = 0, dp2 = 0;
        int i = 0, j = 0;
        while (i < nums1.length || j < nums2.length) {
            if (i < nums1.length && j < nums2.length) {
                if (nums1[i] < nums2[j]) {
                    dp1 += nums1[i++];
                } else if (nums1[i] > nums2[j]) {
                    dp2 += nums2[j++];
                } else {
                    dp1 = dp2 = Math.max(dp1, dp2) + nums1[i];
                    i++;
                    j++;
                }
            } else if (i < nums1.length) {
                dp1 += nums1[i++];
            } else {
                dp2 += nums2[j++];
            }
        }
        
        return (int) (Math.max(dp1, dp2) % MOD);
    }
}
