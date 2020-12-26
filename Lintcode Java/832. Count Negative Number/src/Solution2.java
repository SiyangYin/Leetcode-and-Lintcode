public class Solution2 {
    /**
     * @param nums: the sorted matrix
     * @return: the number of Negative Number
     */
    public int countNumber(int[][] nums) {
        // Write your code here
        int res = 0;
        int x = nums.length - 1, y = 0;
        while (x >= 0 && y < nums[0].length) {
            if (nums[x][y] < 0) {
                res += x + 1;
                y++;
            } else {
                x--;
            }
        }
        
        return res;
    }
}
