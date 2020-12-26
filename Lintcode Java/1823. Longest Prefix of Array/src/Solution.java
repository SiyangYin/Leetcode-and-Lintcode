public class Solution {
    /**
     * @param X:    a integer
     * @param Y:    a integer
     * @param nums: a list of integer
     * @return: return the maximum index of largest prefix
     */
    public int LongestPrefix(int X, int Y, int[] nums) {
        // write your code here
        int countX = 0, countY = 0;
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == X) {
                countX++;
            }
            if (nums[i] == Y) {
                countY++;
            }
            
            if (countX == countY && countX > 0) {
                res = Math.max(res, i);
            }
        }
        
        return res;
    }
}
