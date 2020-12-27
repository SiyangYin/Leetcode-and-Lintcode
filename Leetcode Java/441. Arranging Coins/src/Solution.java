public class Solution {
    public int arrangeCoins(int n) {
        int row = 1, res = 0;
        while (n >= row) {
            n -= row;
            res++;
            row++;
        }
        
        return res;
    }
}
