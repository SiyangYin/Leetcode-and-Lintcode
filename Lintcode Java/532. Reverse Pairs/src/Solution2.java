public class Solution2 {
    /**
     * @param A: an array
     * @return: total of reverse pairs
     */
    public long reversePairs(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        
        return mergeAndCount(A, 0, A.length - 1);
    }
    
    private long mergeAndCount(int[] A, int l, int r) {
        if (l == r) {
            return 0;
        }
        
        int mid = l + (r - l >> 1);
        long count = 0;
        count += mergeAndCount(A, l, mid);
        count += mergeAndCount(A, mid + 1, r);
        
        int[] tmp = new int[r - l + 1];
        int ind = 0, left = l, right = mid + 1;
        while (left <= mid && right <= r) {
            if (A[left] <= A[right]) {
                tmp[ind++] = A[left++];
            } else {
                count += mid - left + 1;
                tmp[ind++] = A[right++];
            }
        }
        
        while (left <= mid) {
            tmp[ind++] = A[left++];
        }
        while (right <= r) {
            tmp[ind++] = A[right++];
        }
    
        for (int i = l; i <= r; i++) {
            A[i] = tmp[i - l];
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution2().reversePairs(new int[]{2, 4, 1, 3, 5}));
    }
}
