import java.util.Arrays;

public class Solution {
    /**
     * @param cost: the cost
     * @param val: the val
     * @return: the all cost
     */
    public long doingHomework(int[] cost, int[] val) {
        // Write your code here.
        long total = 0L;
        Arrays.sort(val);
        
        long curCost = 0L;
        int skipPerson = 0;
        int i = 0;
        while (i < cost.length && skipPerson < val.length) {
            curCost += cost[i];
            if (val[skipPerson] >= curCost) {
                total += cost[i] * (val.length - skipPerson);
                i++;
            } else {
                skipPerson++;
                curCost -= cost[i];
            }
        }
        
        return total;
    }
    
    public static void main(String[] args) {
        int[] cost = {1, 2, 3, 5};
        int[] val = {6, 10, 4};
    
        System.out.println(new Solution().doingHomework(cost, val));
    }
}
