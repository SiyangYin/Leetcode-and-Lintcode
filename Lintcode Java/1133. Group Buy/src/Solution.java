public class Solution {
    /**
     * @param x: the number of people who plan to buy goods A.
     * @param y: the number of people who plan to buy goods B.
     * @param z: the number of people who plan to buy goods C.
     * @return: return the maximum times they can group buy.
     */
    public int groupBuyTimes(int x, int y, int z) {
        // write your code here
        int res = (x + y + z) / 3;
        res = Math.min(res, x);
        res = Math.min(res, y);
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().groupBuyTimes(60, 40, 15));
    }
}
