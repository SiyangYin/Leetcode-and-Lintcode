public class Solution {
    /*
     * @param A: A list of integers
     * @param elem: An integer
     * @return: The new length after remove
     */
    public int removeElement(int[] A, int elem) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        int i = 0, j = 0;
        while (j < A.length) {
            if (A[j] == elem) {
                j++;
            } else {
                A[i++] = A[j++];
            }
        }
        return i;
    }
}