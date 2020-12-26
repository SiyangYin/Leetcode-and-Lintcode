public class Solution {
    /**
     * @param nums: an array
     * @return: the minimum number of moves required to make all array elements equal
     */
    public int minMoves(int[] nums) {
        // Write your code here
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
        }
    
        int res = 0;
        for (int num : nums) {
            res += num - min;
        }
        
        return res;
    }
}
