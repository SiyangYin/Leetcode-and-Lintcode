import java.util.Arrays;

public class Solution2 {
    /**
     * @param intervals: the intervals
     * @param rooms:     the sum of rooms
     * @param ask:       the ask
     * @return: true or false of each meeting
     */
    public boolean[] meetingRoomIII(int[][] intervals, int rooms, int[][] ask) {
        // Write your code here.
        int max = 0;
        for (int i = 0; i < intervals.length; i++) {
            max = Math.max(max, intervals[i][1]);
        }
        for (int i = 0; i < ask.length; i++) {
            max = Math.max(max, ask[i][1]);
        }
        
        int[] mark = new int[max + 1], need = new int[max + 1];
        for (int i = 0; i < intervals.length; i++) {
            mark[intervals[i][0]]++;
            mark[intervals[i][1]]--;
        }
        
        int count = 0;
        for (int i = 0; i < mark.length; i++) {
            count += mark[i];
            if (count < rooms) {
                need[i] = 0;
            } else {
                need[i] = 1;
            }
        }
        
        int[] sum = new int[max + 1];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + need[i];
        }
        
        System.out.println("mark");
        for (int i = 0; i < mark.length; i++) {
            System.out.print(mark[i] +"\t");
        }
        System.out.println();
        System.out.println("need");
        for (int i = 0; i < need.length; i++) {
            System.out.print(need[i] + "\t");
        }
        System.out.println();
        System.out.println("sum");
        for (int i = 0; i < sum.length; i++) {
            System.out.print(sum[i] + "\t");
        }
        System.out.println();
        
        boolean[] res = new boolean[ask.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = sum[ask[i][0] - 1] == sum[ask[i][1] - 1];
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[][] ints = {{1, 2}, {4, 5}, {8, 10}};
        int[][] ask = {{4, 5}, {5, 6}};
        // int[][] ask = {{2, 3}, {3, 4}};
        System.out.println(Arrays.toString(new Solution2().meetingRoomIII(ints, 1, ask)));
    }
}
