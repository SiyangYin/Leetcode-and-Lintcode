public class Solution {
    public int longestMountain(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int l = 0, r = 0;
        int res = 0;
        while (l < A.length) {
            while (l < A.length - 1 && A[l] == A[l + 1]) {
                l++;
            }
            
            if (l == A.length - 1) {
                break;
            }
            
            r = l + 1;
            boolean up = false, down = false;
            while (r < A.length && A[r - 1] < A[r]) {
                r++;
                up = true;
            }
            while (r < A.length && A[r - 1] > A[r]) {
                r++;
                down = true;
            }
            
            r--;
            if (up && down) {
                res = Math.max(res, r - l + 1);
            }
            l = r;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        // int[] A = {2, 2, 2};
        int[] A = {2, 1, 4, 7, 3, 2, 5};
        System.out.println(new Solution().longestMountain(A));
    }
}
