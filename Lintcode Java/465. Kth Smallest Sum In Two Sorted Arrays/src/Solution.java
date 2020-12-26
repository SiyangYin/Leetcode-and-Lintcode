public class Solution {
    /**
     * @param A: an integer arrays sorted in ascending order
     * @param B: an integer arrays sorted in ascending order
     * @param k: An integer
     * @return: An integer
     */
    public int kthSmallestSum(int[] A, int[] B, int k) {
        // write your code here
        int l = A[0] + B[0], r = A[A.length - 1] + B[B.length - 1];
        while (l < r) {
            int m = l + (r - l >> 1);
            if (countLessEq(A, B, m) >= k) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        
        return l;
    }
    
    private int countLessEq(int[] A, int[] B, int target) {
        int count = 0;
        int x = B.length - 1, y = 0;
        while (x >= 0 && y < A.length) {
            if (A[y] + B[x] <= target) {
                count += x + 1;
                y++;
            } else {
                x--;
            }
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        int[] A = {1, 7, 11}, B = {2, 4, 6};
        System.out.println(new Solution().kthSmallestSum(A, B, 3));
    }
}
