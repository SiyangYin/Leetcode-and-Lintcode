import java.util.Arrays;

public class Solution {
    /**
     * @param A: The array A.
     * @return: The array of the squares.
     */
    public int[] SquareArray(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return A;
        }
        
        for (int i = 0; i < A.length; i++) {
            A[i] = A[i] * A[i];
        }
    
        Arrays.sort(A);
        return A;
    }
}
