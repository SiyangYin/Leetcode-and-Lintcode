import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        int[] res = new int[n];
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        
        for (int[] path : paths) {
            graph.get(path[0] - 1).add(path[1] - 1);
            graph.get(path[1] - 1).add(path[0] - 1);
        }
        
        for (int i = 0; i < n; i++) {
            boolean[] used = new boolean[5];
            
            for (int j : graph.get(i)) {
                used[res[j]] = true;
            }
            
            for (int j = 4; j > 0; j--) {
                if (!used[j]) {
                    res[i] = j;
                    break;
                }
            }
        }
        
        return res;
    }
}
