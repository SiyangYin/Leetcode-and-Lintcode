import java.util.HashMap;
import java.util.Map;

public class Solution3 {
    public int minKnightMoves(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        Map<String, Integer> map = new HashMap<>();
        
        return dfs(x, y, map);
    }
    
    private int dfs(int x, int y, Map<String, Integer> map) {
        if (x + y == 0) {
            return 0;
        } else if (x + y == 2) {
            return 2;
        }
        
        String pos = x + "," + y;
        if (map.containsKey(pos)) {
            return map.get(pos);
        }
        
        map.put(pos, 1 + Math.min(dfs(Math.abs(x - 1), Math.abs(y - 2), map), dfs(Math.abs(x - 2), Math.abs(y - 1), map)));
        return map.get(pos);
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution3().minKnightMoves(2, 1));
    }
}
