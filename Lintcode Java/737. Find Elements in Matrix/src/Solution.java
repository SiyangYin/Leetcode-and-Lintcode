import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * @param Matrix: the input
     * @return: the element which appears every row
     */
    public int FindElements(int[][] Matrix) {
        // write your code here
        Map<Integer, Integer> map = new HashMap<>();
        for (int e : Matrix[0]) {
            map.put(e, 1);
        }
    
        for (int i = 1; i < Matrix.length; i++) {
            for (int j = 0; j < Matrix[0].length; j++) {
                int e = Matrix[i][j];
                if (map.containsKey(e) && map.get(e) == i) {
                    map.put(e, i + 1);
                }
            }
        }
    
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == Matrix.length) {
                return entry.getKey();
            }
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        int[][] m = {{2, 5, 3}, {3, 2, 1}, {1, 3, 5}};
        System.out.println(new Solution().FindElements(m));
    }
}
