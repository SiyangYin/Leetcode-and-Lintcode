import java.util.ArrayList;
import java.util.List;

public class Solution {
    
    class Pair {
        int start, end, value;
        
        public Pair(int start, int end, int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }
    }
    
    /**
     * @param meeting: the meetings
     * @param value:   the value
     * @return: calculate the max value
     */
    public int maxValue(int[][] meeting, int[] value) {
        // write your code here
        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < meeting.length; i++) {
            list.add(new Pair(meeting[i][0], meeting[i][1], value[i]));
        }
        
        list.sort((p1, p2) -> Integer.compare(p1.end, p2.end));
        int[] dp = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            Pair cur = list.get(i);
            if (i == 0) {
                dp[i] = cur.value;
            } else {
                int idx = binarySearch(list, i - 1, cur.start);
                if (idx == -1) {
                    dp[i] = Math.max(dp[i - 1], cur.value);
                } else {
                    dp[i] = Math.max(dp[i - 1], dp[idx] + cur.value);
                }
            }
        }
        
        return dp[dp.length - 1];
    }
    
    private int binarySearch(List<Pair> list, int r, int target) {
        int l = 0;
        while (l < r) {
            int m = l + (r - l + 1 >> 1);
            if (list.get(m).end <= target) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        
        return list.get(l).end <= target ? l : -1;
    }
    
    public static void main(String[] args) {
        int[][] meet = {{10, 40}, {20, 50}, {30, 45}, {40, 60}};
        int[] val = {3, 6, 2, 4};
        System.out.println(new Solution().maxValue(meet, val));
    }
}
