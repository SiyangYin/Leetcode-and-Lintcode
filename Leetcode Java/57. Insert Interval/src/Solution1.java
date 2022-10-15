import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        if (intervals.length == 0) return new int[][] {newInterval};
        if (newInterval[0] < intervals[0][0]) {
            res.add(newInterval);
        }
        else {
            res.add(intervals[0]);
        }
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][1] < newInterval[0]) {
                if (res.get(res.size() - 1)[1] < intervals[i][0]) {
                    res.add(intervals[i]);
                }
            }
            else {
                if (newInterval[1] < intervals[i][0]) {
                    if (res.get(res.size() - 1)[1] < newInterval[0]) {
                        res.add(newInterval);
                    }
                    res.add(intervals[i]);
                }
                else {
                    if (Math.min(intervals[i][0], newInterval[0]) <= res.get(res.size() - 1)[1]) {
                        res.get(res.size() - 1)[0] = Math.min(res.get(res.size() - 1)[0], Math.min(intervals[i][0], newInterval[0]));
                        res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], Math.max(intervals[i][1], newInterval[1]));
                    }
                    else {
                        res.add(new int[]{Math.min(intervals[i][0], newInterval[0]), Math.max(intervals[i][1], newInterval[1])});
                    }
                }
            }
        }
        if (res.get(res.size() - 1)[1] < newInterval[0]) {
            res.add(newInterval);
        }
        return res.toArray(new int[0][0]);
    }
    
    public static void main(String[] args) {
        // int[][] ins = {{1, 2}, {3, 5}, {6,7},{8,10},{12,16}};
        int[][] ins = {{1, 5}};
        int[] newins = {6, 8};
        System.out.println(Arrays.deepToString(new Solution1().insert(ins, newins)));
    }
}
