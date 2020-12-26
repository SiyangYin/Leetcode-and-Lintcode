import java.util.Arrays;

public class Solution {
    /**
     * @param points: a 2D array
     * @return: the minimum number of arrows that must be shot to burst all balloons
     */
    public int findMinArrowShots(int[][] points) {
        // Write your code here
        if (points == null || points.length == 0 || points[0].length == 0) {
            return 0;
        }
        
        Arrays.sort(points, (i1, i2) -> Integer.compare(i1[1], i2[1]));
        
        int res = 0, cur = Integer.MIN_VALUE;
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            if (point[0] <= cur && cur <= point[1]) {
                continue;
            }
            
            cur = point[1];
            res++;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        System.out.println(new Solution().findMinArrowShots(points));
    }
}
