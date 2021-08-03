import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        List<Integer> id = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            id.add(i);
        }
        id.sort((x, y) -> Integer.compare(position[x], position[y]));
        
        int res = n;
        double last = 0;
        for (int i = n - 1; i >= 0; i--) {
            int idx = id.get(i);
            double time = (double) (target - position[idx]) / speed[idx];
            if (time <= last) {
                res--;
            } else {
                last = time;
            }
        }
        
        return res;
    }
}
