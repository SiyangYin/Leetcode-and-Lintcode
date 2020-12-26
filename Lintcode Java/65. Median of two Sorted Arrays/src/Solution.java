public class Solution {
    /*
     * @param A: An integer array
     * @param B: An integer array
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        // write your code here
        int sumLen = A.length + B.length;
        if (sumLen % 2 != 0) {
            return findKth(A, 0, B, 0, sumLen / 2 + 1);
        } else {
            return (findKth(A, 0, B, 0, sumLen / 2) +
                    findKth(A, 0, B, 0, sumLen / 2 + 1)) / 2.0;
        }
    }
    
    private int findKth(int[] A, int idx1, int[] B, int idx2, int k) {
        if (idx1 >= A.length) {
            return B[idx2 + k - 1];
        }
        if (idx2 >= B.length) {
            return A[idx1 + k - 1];
        }
        
        if (k == 1) {
            return Math.min(A[idx1], B[idx2]);
        }
        
        int halfKOfA = idx1 + k / 2 - 1, halfKOfB = idx2 + k / 2 - 1;
        if (halfKOfA >= A.length || A[halfKOfA] >= B[halfKOfB]) {
            return findKth(A, idx1, B, halfKOfB + 1, k - k / 2);
        }
        if (halfKOfB >= B.length || A[halfKOfA] < B[halfKOfB]) {
            return findKth(A, halfKOfA + 1, B, idx2, k - k / 2);
        }
        
        return 0;
    }
    
    public static void main(String[] args) {
        // int[] A = {1, 2, 3, 4, 5, 6};
        // int[] B = {2, 3, 4, 5};
        
        int[] A = {};
        int[] B = {1};
        
        System.out.println(new Solution().findMedianSortedArrays(A, B));
    }
}