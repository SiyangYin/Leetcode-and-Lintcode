public class Solution {
    /**
     * @param A: an integer array sorted in ascending order
     * @param target: An integer
     * @return: an integer
     */
    public int closestNumber(int[] A, int target) {
        // write your code here
        if (A == null || A.length == 0) {
            return -1;
        }
        
        int l = 0, r = A.length - 1;
        while (l + 1 < r) {
            int m = l + (r - l >> 1);
            if (target < A[m]) {
                r = m;
            } else if (target > A[m]) {
                l = m;
            } else {
                return m;
            }
        }
        
        return Math.abs(A[l] - target) < Math.abs(A[r] - target) ? l : r;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().closestNumber(new int[]{1, 2}, 2));
        System.out.println(new Solution().closestNumber(new int[]{2, 3}, 2));
    }
}
