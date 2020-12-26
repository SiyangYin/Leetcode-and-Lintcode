import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int[] interval : intervals) {
            map.put(interval[0], map.getOrDefault(interval[0], 0) + 1);
            map.put(interval[1], map.getOrDefault(interval[1], 0) - 1);
        }
        
        int res = 0, count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            count += entry.getValue();
            res = Math.max(res, count);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[][] inter = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println(new Solution().minMeetingRooms(inter));
    }
}
