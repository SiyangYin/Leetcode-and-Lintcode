public class Solution {
    /**
     * @param A:      an integer rotated sorted array
     * @param target: an integer to be searched
     * @return: an integer
     */
    public int search(int[] A, int target) {
        // write your code here
        if (A == null || A.length == 0) {
            return -1;
        }
        
        int l = 0, r = A.length - 1;
        while (l < r) {
            int m = l + (r - l + 1 >> 1);
            if (A[m] >= A[0]) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        
        if (A[0] <= target && target <= A[l]) {
            return search(A, 0, l, target);
        } else {
            return search(A, l, A.length - 1, target);
        }
    }
    
    private int search(int[] A, int l, int r, int target) {
        if (l > r) {
            return -1;
        }
        
        while (l < r) {
            int m = l + (r - l + 1 >> 1);
            if (A[m] <= target) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        
        return A[l] == target ? l : -1;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().search(new int[]{4, 5, 1, 2, 3}, 0));
    }
}