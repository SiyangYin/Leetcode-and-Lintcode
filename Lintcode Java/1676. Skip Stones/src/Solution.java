import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * @param n: The total number of stones.
     * @param m: The total number of stones you can remove.
     * @param target: The distance from the end to the starting point.
     * @param d: The array that the distance from the i rock to the starting point is d[i].
     * @return: Return the maximum value of the shortest jump distance.
     */
    public int getDistance(int n, int m, int target, List<Integer> d) {
        // Write your code here.
        if (n == 0) {
            return target;
        }
        
        d.add(target);
        
        int start = 0, end = target;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (validDif(d, mid, m)) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        
        if (validDif(d, end, m)) {
            return end;
        } else {
            return start;
        }
    }
    
    private boolean validDif(List<Integer> d, int dis, int m) {
        int curLoc = 0, ind = 0;
        int count = 0;
        while (ind <= d.size() - 1) {
            if (d.get(ind) - curLoc < dis) {
                count++;
            } else {
                curLoc = d.get(ind);
            }
            
            ind++;
        }
        return count <= m;
    }
    
    public static void main(String[] args) {
        int n = 5, m = 2, target = 25;
        List<Integer> d = new ArrayList<>(Arrays.asList(2, 11, 14, 17, 21));
        System.out.println(new Solution().getDistance(n, m, target, d));
        
    }
}
