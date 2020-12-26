public class Solution {
    /**
     * @param A: the array
     * @return: true or false
     */
    public boolean validMountainArray(int[] A) {
        // Write your code here.
        if (A.length < 3) {
            return false;
        }
        
        int i = 1;
        while (i < A.length && A[i] > A[i - 1]) {
            i++;
        }
        
        if (i == 1 || i == A.length) {
            return false;
        }
        
        int j = i;
        while (j < A.length && A[j] < A[j - 1]) {
            j++;
        }
        
        if (j == i) {
            return false;
        }
        
        return j == A.length;
    }
}
