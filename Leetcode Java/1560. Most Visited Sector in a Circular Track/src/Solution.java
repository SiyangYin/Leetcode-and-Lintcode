import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> mostVisited(int n, int[] rounds) {
        List<Integer> res = new ArrayList<>();
        int start = rounds[0], end = rounds[rounds.length - 1];
        if (end >= start) {
            for (int i = start; i <= end; i++) {
                res.add(i);
            }
        } else {
            for (int i = 1; i <= end; i++) {
                res.add(i);
            }
            for (int i = start; i <= n; i++) {
                res.add(i);
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[] rou = {1,3,5,7};
        System.out.println(new Solution().mostVisited(7, rou));
    }
}
