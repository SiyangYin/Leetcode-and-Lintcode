import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0) {
            return new int[][]{newInterval};
        }
        
        List<int[]> list = new ArrayList<>();
        
        int i;
        for (i = 0; i < intervals.length && intervals[i][1] < newInterval[0]; i++) {
            list.add(intervals[i]);
        }
        
        if (i < intervals.length) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
                i++;
            }
        }
    
        list.add(newInterval);
        while (i < intervals.length) {
            list.add(intervals[i]);
            i++;
        }
        
        
        int[][] res = new int[list.size()][];
        for (int j = 0; j < res.length; j++) {
            res[j] = list.get(j);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        // int[][] ins = {{1, 2}, {3, 5}, {6,7},{8,10},{12,16}};
        int[][] ins = {{1, 5}};
        int[] newins = {6, 8};
        System.out.println(Arrays.deepToString(new Solution().insert(ins, newins)));
    }
}
