public class Solution2 {
    /**
     * @param n: number of lights
     * @param m: number of operations
     * @return: the number of status
     */
    public int flipLights(int n, int m) {
        // write your code here
        n = Math.min(n, 3);
        if (m == 0) {
            return 1;
        }
        if (m == 1) {
            return n + 1;
        }
        if (m == 2) {
            if (n == 3) {
                return 7;
            } else {
                return 1 << n;
            }
        }
        
        return 1 << n;
    }
}
