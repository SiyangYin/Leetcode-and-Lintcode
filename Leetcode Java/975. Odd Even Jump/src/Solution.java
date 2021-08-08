import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public int oddEvenJumps(int[] arr) {
        int n = arr.length;
        boolean[][] f = new boolean[n][2];
        f[n - 1][0] = f[n - 1][1] = true;
        
        int res = 1;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(arr[n - 1], n - 1);
        for (int i = n - 2; i >= 0; i--) {
            int x = arr[i];
            Map.Entry<Integer, Integer> floor = map.floorEntry(x), ceil = map.ceilingEntry(x);
            if (floor != null) {
                f[i][0] = f[floor.getValue()][1];
            }
            if (ceil != null) {
                f[i][1] = f[ceil.getValue()][0];
            }
        
            map.put(arr[i], i);
            
            if (f[i][1]) {
                res++;
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(1, 2);
        System.out.println(map.ceilingKey(0));
        System.out.println(map.ceilingKey(-1));
    }
}
