public class Solution {
    /**
     * @param A: An integer array
     * @return: An integer
     */
    public int singleNumber(int[] A) {
        // write your code here
        int res = 0;
        for (int i : A) {
            res ^= i;
        }
        return res;
    }
}