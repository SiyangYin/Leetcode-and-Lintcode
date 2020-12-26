public class Solution {
    public int maxSum(int[] nums1, int[] nums2) {
        int MOD = (int) (1e9 + 7);
        
        long[] dp1 = new long[nums1.length], dp2 = new long[nums2.length];
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                dp1[i] = ((i >= 1 ? dp1[i - 1] : 0) + nums1[i]);
                i++;
            } else if (nums1[i] > nums2[j]) {
                dp2[j] = ((j >= 1 ? dp2[j - 1] : 0) + nums2[j]);
                j++;
            } else {
                dp1[i] = dp2[j] = (Math.max(i >= 1 ? dp1[i - 1] : 0, j >= 1 ? dp2[j - 1] : 0) + nums1[i]);
                i++;
                j++;
            }
        }
        
        while (i < nums1.length) {
            dp1[i] = (i >= 1 ? dp1[i - 1] : 0) + nums1[i];
            i++;
        }
        while (j < nums2.length) {
            dp2[j] = (j >= 1 ? dp2[j - 1] : 0) + nums2[j];
            j++;
        }
        
        return (int) (Math.max(dp1[nums1.length - 1], dp2[nums2.length - 1]) % MOD);
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().maxSum(new int[]{2, 4, 5, 8, 10}, new int[]{4, 6, 8, 9}));
    }
}
