public class Solution {
    /**
     * @param heights: a list of integers
     * @return: a integer
     */
    public int trapRainWater(int[] heights) {
        // write your code here
        if (heights == null || heights.length <= 2) {
            return 0;
        }
        
        int res = 0;
        
        int l = 0, r = heights.length - 1;
        int maxL = heights[0], maxR = heights[r];
        while (l < r) {
            if (maxL < maxR) {
                l++;
                if (heights[l] < maxL) {
                    res += maxL - heights[l];
                } else {
                    maxL = heights[l];
                }
            } else {
                r--;
                if (heights[r] < maxR) {
                    res += maxR - heights[r];
                } else {
                    maxR = heights[r];
                }
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().trapRainWater(new int[]{0, 1, 0}));
        System.out.println(new Solution().trapRainWater(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
