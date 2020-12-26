public class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            flip(A[i]);
            invert(A[i]);
        }
        
        return A;
    }
    
    private void flip(int[] row) {
        for (int i = 0, j = row.length - 1; i < j; i++, j--) {
            int tmp = row[i];
            row[i] = row[j];
            row[j] = tmp;
        }
    }
    
    private void invert(int[] row) {
        for (int i = 0; i < row.length; i++) {
            row[i] ^= 1;
        }
    }
}
