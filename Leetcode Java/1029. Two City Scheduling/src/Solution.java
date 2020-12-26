import java.util.Arrays;

public class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (c1, c2) -> Integer.compare(c1[0] - c1[1], c2[0] - c2[1]));
        int res = 0;
    
        for (int i = 0; i < costs.length; i++) {
            if (i < costs.length / 2) {
                res += costs[i][0];
            } else {
                res += costs[i][1];
            }
        }
        
        return res;
    }
}
