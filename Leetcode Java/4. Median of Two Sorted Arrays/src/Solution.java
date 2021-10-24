public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if (len % 2 == 0) {
            return (findKSmallest(nums1, 0, nums2, 0, len / 2) +
                    findKSmallest(nums1, 0, nums2, 0, len / 2 + 1)) / 2.0;
        } else {
            return findKSmallest(nums1, 0, nums2, 0, len / 2 + 1);
        }
    }
    
    private int findKSmallest(int[] nums1, int s1, int[] nums2, int s2, int k) {
        if (s1 == nums1.length) {
            return nums2[s2 + k - 1];
        }
        
        if (s2 == nums2.length) {
            return nums1[s1 + k - 1];
        }
        
        if (k == 1) {
            return Math.min(nums1[s1], nums2[s2]);
        }
        
        if (s1 + k / 2 - 1 > nums1.length - 1) {
            return findKSmallest(nums1, s1, nums2, s2 + k / 2, k - k / 2);
        }
        
        if (s2 + k / 2 - 1 > nums2.length - 1) {
            return findKSmallest(nums1, s1 + k / 2, nums2, s2, k - k / 2);
        }
        
        if (nums1[s1 + k / 2 - 1] < nums2[s2 + k / 2 - 1]) {
            return findKSmallest(nums1, s1 + k / 2, nums2, s2, k - k / 2);
        } else {
            return findKSmallest(nums1, s1, nums2, s2 + k / 2, k - k / 2);
        }
    }
    
    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(new Solution().findMedianSortedArrays(nums1, nums2));
    }
}
