public class Solution {
    /**
     * @param gas:  An array of integers
     * @param cost: An array of integers
     * @return: An integer
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // write your code here
        for (int i = 0, j = 0; i < gas.length; ) {
            int curGas = 0;
            for (j = 1; j <= gas.length; j++) {
                int idx = (i + j - 1) % gas.length;
                curGas += gas[idx] - cost[idx];
                if (curGas < 0) {
                    i += j;
                    break;
                }
                
                if (j == gas.length) {
                    return i;
                }
            }
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().canCompleteCircuit(new int[]{1, 1, 3, 1}, new int[]{2, 2, 1, 1}));
        System.out.println(new Solution().canCompleteCircuit(new int[]{4}, new int[]{5}));
        System.out.println(new Solution().canCompleteCircuit(new int[]{2,4}, new int[]{3,4}));
    }
}
