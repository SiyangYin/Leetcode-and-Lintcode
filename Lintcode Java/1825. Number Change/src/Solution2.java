public class Solution2 {
    /**
     * @param k: integer k
     * @return: minimum number of operations that change 0 to k
     */
    public int numberChange(int k) {
        // write your code here
        int res = 0;
        while (k > 0) {
            if (k % 2 == 0) {
                k /= 2;
            } else {
                k--;
            }
            
            res++;
        }
        
        return res;
    }
}
