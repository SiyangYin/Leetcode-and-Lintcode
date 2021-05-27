public class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int res = 0;
        int[][] f = new int[nums1.length + 1][nums2.length + 1];
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] != nums2[j]) {
                    continue;
                }
                
                f[i + 1][j + 1] = 1 + f[i][j];
                res = Math.max(res, f[i + 1][j + 1]);
            }
        }
        
        return res;
    }
}
