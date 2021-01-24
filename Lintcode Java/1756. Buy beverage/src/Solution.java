public class Solution {
    /**
     * @param budget:   the money
     * @param cost:     one beverage need money
     * @param exchange: one beverage need point
     * @return: return the shortest time
     */
    public int buyBeverage(int budget, int cost, int exchange) {
        // write your code here
        int res = budget / cost, score = res;
        while (score >= exchange) {
            int tmp = score / exchange;
            res += tmp;
            score = tmp + score % exchange;
        }
        
        return res;
    }
}
