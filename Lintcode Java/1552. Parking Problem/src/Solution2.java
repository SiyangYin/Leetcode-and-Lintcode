import java.util.Map;
import java.util.TreeMap;

public class Solution2 {
    /**
     * @param a: the Parking Record
     * @return: The max number of cars
     */
    public int getMax(int[][] a) {
        // Write your code here
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] t : a) {
            if (t[0] >= t[1]) {
                continue;
            }
            
            map.put(t[0], map.getOrDefault(t[0], 0) + 1);
            map.put(t[1], map.getOrDefault(t[1], 0) - 1);
        }
    
        int res = 0, count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            count += entry.getValue();
            res = Math.max(res, count);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        // int[][] a = {{1, 9}, {2, 8}, {3, 7}, {4, 6}, {5, 5}};
        int[][] a = {{1, 4}, {2, 4}, {3, 4}, {4, 5}, {5, 5}};
        System.out.println(new Solution2().getMax(a));
    }
}
