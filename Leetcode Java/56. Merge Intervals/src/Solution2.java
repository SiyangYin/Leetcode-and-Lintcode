import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return intervals;
        }
    
        Arrays.sort(intervals, (i1, i2) -> i1[0] != i2[0] ? i1[0] - i2[0] : i1[1] - i2[1]);
        
        List<int[]> list = new ArrayList<>();
        int start = intervals[0][0], end = intervals[0][1];
    
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
            } else {
                list.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        
        list.add(new int[]{start, end});
        int[][] res = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            res[i] = new int[]{list.get(i)[0], list.get(i)[1]};
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(Arrays.deepToString(new Solution2().merge(intervals)));
    }
}
