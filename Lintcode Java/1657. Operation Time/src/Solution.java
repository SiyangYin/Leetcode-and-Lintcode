import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * @param op: the operation
     * @param a: time of each operation
     * @return: the max sum
     */
    public int operationTime(int[] op, int[] a) {
        // Write your code here.
        Map<Integer, Integer> maxMap = new HashMap<>(), minMap = new HashMap<>();
    
        for (int i = 0; i < op.length; i++) {
            maxMap.put(op[i], Math.max(maxMap.getOrDefault(op[i], 0), a[i]));
            minMap.put(op[i], Math.min(minMap.getOrDefault(op[i], Integer.MAX_VALUE), a[i]));
        }
        
        int res = 0;
        for (int i = 0; i < op.length; i++) {
            res = Math.max(res, maxMap.get(op[i]) - minMap.get(op[i]));
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[] op = {1,2,1,2}, a = {100,300,400,500};
        System.out.println(new Solution().operationTime(op, a));
    }
}
