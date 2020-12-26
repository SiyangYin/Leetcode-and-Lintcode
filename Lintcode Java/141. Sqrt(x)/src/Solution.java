public class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        // write your code here
        long l = 0, r = x;
        while (l < r) {
            long m = l + (r - l + 1 >> 1);
            if (m <= x / m) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        
        return (int) l;
    }
}
