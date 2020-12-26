public class Solution2 {
    /**
     * @param A:
     * @return: the length of the longest mountain
     */
    public int longestMountain(int[] A) {
        // write your code here
        int res = 0;
        int up = 0, down = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] == A[i - 1] || (A[i] < A[i - 1] && up == 0)) {
                up = down = 0;
            } else if (A[i] > A[i - 1] && down > 0) {
                down = 0;
                up = 1;
            } else if (A[i] > A[i - 1]) {
                up++;
            } else if (A[i] < A[i - 1]) {
                down++;
            }
            
            if (up > 0 && down > 0) {
                res = Math.max(res, up + down + 1);
            }
        }
        
        return res;
    }
}
