class Solution {
    public int[] finalPrices(int[] prices) {
        int[] stk = new int[prices.length];
        int top = 0;
        
        for (int i = 0; i < prices.length; i++) {
            while (top > 0 && prices[stk[top - 1]] >= prices[i]) {
                prices[stk[--top]] -= prices[i];
            }
            
            stk[top++] = i;
        }
        
        return prices;
    }
}