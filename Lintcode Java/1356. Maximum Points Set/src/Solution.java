import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    /**
     * @param Points: a list of [x, y]
     * @return: return a list of points
     */
    public List<List<Integer>> MaximumPointsSet(int[][] Points) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(Points, (p1, p2) -> -Integer.compare(p1[0], p2[0]));
        
        int maxY = 0;
        for (int i = 0; i < Points.length; i++) {
            if (i == 0 || Points[i][1] >= maxY) {
                List<Integer> p = new ArrayList<>(Arrays.asList(Points[i][0], Points[i][1]));
                res.add(p);
                maxY = Points[i][1];
            }
        }
    
        Collections.reverse(res);
        return res;
    }
    
    public static void main(String[] args) {
        int[][] p = {{1, 2}, {5, 3}, {4, 6}, {7, 5}, {9, 0}};
        System.out.println(new Solution().MaximumPointsSet(p));
    }
}
