public class Solution {
    /**
     * @param a: the array a
     * @param L: the integer L
     * @param R: the integer R
     * @return: Return the number of legal integers
     */
    public int getNum(int[] a, int L, int R) {
        // Write your code here
        int res = 0;
        for (int n : a) {
            if (L <= n && n <= R) {
                res++;
            }
        }
        
        return res;
    }
}
