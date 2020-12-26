public class Solution2 {
    /**
     * @param x: the number of people who plan to buy goods A.
     * @param y: the number of people who plan to buy goods B.
     * @param z: the number of people who plan to buy goods C.
     * @return: return the maximum times they can group buy.
     */
    public int groupBuyTimes(int x, int y, int z) {
        // write your code here
        int res = 0;
        for (int a = 0; a <= z; a++) {
            for (int b = 0; b <= x - a; b++) {
                if (a + b <= x && a + 2 * b <= y) {
                    if (a + b > res) {
                        res = Math.max(res, a + b);
                    }
                }
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution2().groupBuyTimes(60, 40, 15));
    }
}
