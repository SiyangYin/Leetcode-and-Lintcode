public class Solution {
    /**
     * @param A: The 2-dimension array
     * @return: Return the column the leftmost one is located
     */
    public int getColumn(int[][] A) {
        // Write your code here
        int res = A[0].length;
        for (int[] row : A) {
            res = Math.min(res, find(row));
        }
        
        return res;
    }
    
    private int find(int[] A) {
        int l = 0, r = A.length - 1;
        while (l < r) {
            int m = l + (r - l >> 1);
            if (A[m] == 1) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        
        return l;
    }
}
