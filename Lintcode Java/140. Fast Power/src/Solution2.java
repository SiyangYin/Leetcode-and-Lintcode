public class Solution2 {
    /**
     * @param a: A 32bit integer
     * @param b: A 32bit integer
     * @param n: A 32bit integer
     * @return: An integer
     */
    public int fastPower(int a, int b, int n) {
        long res = 1, x = a;
        
        while (n != 0) {
            if (n % 2 == 1) {
                res = (res * x) % b;
            }
            
            x = (x * x) % b;
            n >>= 1;
        }
        
        return (int) res % b;
    }
}