public class Solution {
    /**
     * @param A: an integer sorted array
     * @param target: an integer to be inserted
     * @return: An integer
     */
    public int searchInsert(int[] A, int target) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        int l = 0, r = A.length - 1;
        while (l < r) {
            int mid = l + (r - l >> 1);
            if (A[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        
        return A[l] >= target ? l : A.length;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().searchInsert(new int[]{1, 3, 5, 6}, 5));
    }
}