public class Solution1 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int start = -1;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            if (sum < min) {
                min = sum;
                if (i + 1 < gas.length) {
                    start = i + 1;
                }
                else {
                    start = 0;
                }
            }
        }
        return sum >= 0 ? start : -1;
    }
    
    public static void main(String[] args) {
        int[] g = {2, 3, 4}, c = {3, 4, 3};
        System.out.println(new Solution1().canCompleteCircuit(g, c));
    }
}
