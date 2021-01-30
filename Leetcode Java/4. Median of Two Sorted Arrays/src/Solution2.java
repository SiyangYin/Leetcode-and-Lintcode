public class Solution2 {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length, n = B.length;
        if (A.length == 0) {
            return B.length % 2 == 1 ? B[n / 2] : (double) (B[n / 2 - 1] + B[n / 2]) / 2;
        } else if (B.length == 0) {
            return A.length % 2 == 1 ? A[m / 2] : (double) (A[m / 2 - 1] + A[m / 2]) / 2;
        }
        
        int l = m + n;
        if (l % 2 == 1) {
            return search(A, B, l / 2 + 1);
        } else {
            return (double) (search(A, B, l / 2) + search(A, B, l / 2 + 1)) / 2;
        }
    }
    
    // 返回的是最小的小于等于它的数有大于等于k个的那个数，即第k小的数
    private int search(int[] A, int[] B, int k) {
        int l = Math.min(A[0], B[0]), r = Math.max(A[A.length - 1], B[B.length - 1]);
        while (l < r) {
            int m = l + (r - l >> 1);
            if (count(A, m) + count(B, m) >= k) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        
        return l;
    }
    
    // 返回A里小于等于t的数有多少个
    private int count(int[] A, int t) {
        int l = 0, r = A.length - 1;
        while (l < r) {
            int m = l + (r - l + 1 >> 1);
            if (A[m] <= t) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        
        return A[l] <= t ? l + 1 : 0;
    }
}