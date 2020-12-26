public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            int oil = 0, j = 0, pos = 0;
            for (j = 0; j < gas.length; j++) {
                pos = (i + j) % gas.length;
                oil += gas[pos] - cost[pos];
                if (oil < 0) {
                    break;
                }
            }
            
            if (j == gas.length) {
                return i;
            } else {
                i += j;
            }
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        int[] g = {2, 3, 4}, c = {3, 4, 3};
        System.out.println(new Solution().canCompleteCircuit(g, c));
    }
}
