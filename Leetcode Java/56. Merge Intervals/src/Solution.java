import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return intervals;
        }
        
        Arrays.sort(intervals, (o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]);
        List<int[]> list = new ArrayList<>();
        int start = Integer.MIN_VALUE, end = Integer.MIN_VALUE;
    
        for (int[] interval : intervals) {
            if (end < interval[0]) {
                if (start != Integer.MIN_VALUE) {
                    list.add(new int[]{start, end});
                }
                start = interval[0];
                end = interval[1];
            } else {
                end = Math.max(end, interval[1]);
            }
        }
        
        if (start != Integer.MIN_VALUE) {
            list.add(new int[]{start, end});
        }
    
        for (int[] ints : list) {
            System.out.println(Arrays.toString(ints));
        }
    
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i][0] = list.get(i)[0];
            res[i][1] = list.get(i)[1];
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(Arrays.deepToString(new Solution().merge(intervals)));
    }
}
