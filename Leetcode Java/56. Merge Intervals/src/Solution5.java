import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution5 {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (res.get(res.size() - 1)[1] >= intervals[i][0]) {
                res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], intervals[i][1]);
            }
            else {
                res.add(intervals[i]);
            }
        }
        return res.toArray(new int[0][0]);
    }
    
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(Arrays.deepToString(new Solution5().merge(intervals)));
    }
}
