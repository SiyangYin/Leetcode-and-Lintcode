public class Solution {
    /**
     * @param piles: an array
     * @param H: an integer
     * @return: the minimum integer K
     */
    public int minEatingSpeed(int[] piles, int H) {
        // Write your code here
        int l = 1, r = 0;
        for (int i = 0; i < piles.length; i++) {
            r = Math.max(r, piles[i]);
        }
        
        while (l < r) {
            int m = l + (r - l >> 1);
            
            int hours = 0;
            for (int i = 0; i < piles.length; i++) {
                hours += piles[i] / m;
                if (piles[i] % m != 0) {
                    hours++;
                }
            }
            
            if (hours <= H) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        
        return l;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
    }
}
