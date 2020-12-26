import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3 {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return intervals;
        }
        
        Arrays.sort(intervals, (i1, i2) -> {
            if (i1[0] != i2[0]) {
                return i1[0] < i2[0] ? -1 : 1;
            } else {
                if (i1[1] != i2[1]) {
                    return i1[1] < i2[1] ? -1 : 1;
                } else {
                    return 0;
                }
            }
        });
        
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            merge(list, list.get(list.size() - 1), intervals[i]);
        }
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
    
    private void merge(List<int[]> list, int[] last, int[] cur) {
        if (last[1] < cur[0]) {
            list.add(cur);
        } else {
            last[1] = Math.max(last[1], cur[1]);
        }
        
        list.sort((i1, i2) -> i1[0] - i2[0]);
    }
}
