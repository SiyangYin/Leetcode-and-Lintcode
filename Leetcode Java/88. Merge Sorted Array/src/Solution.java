public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null) {
            return;
        }
        int end = nums1.length - 1;
        m--; n--;
        while (m >= 0 && n >= 0) {
            if (nums1[m] >= nums2[n]) {
                nums1[end--] = nums1[m--];
            } else {
                nums1[end--] = nums2[n--];
            }
        }
        while (m >= 0) {
            nums1[end--] = nums1[m--];
        }
        while (n >= 0) {
            nums1[end--] = nums2[n--];
        }
//        System.out.println(Arrays.toString(nums1));
    }
    
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        
        new Solution().merge(nums1, 3, nums2, 3);
    }
}