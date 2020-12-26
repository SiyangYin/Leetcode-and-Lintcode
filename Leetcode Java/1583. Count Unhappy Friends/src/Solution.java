import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int[][] prefMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                prefMatrix[i][preferences[i][j]] = j + 1;
            }
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] pair : pairs) {
            map.put(pair[0], pair[1]);
            map.put(pair[1], pair[0]);
        }
        
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int x = entry.getKey(), y = entry.getValue();
            for (int i = 0; i < n; i++) {
                if (i == x) {
                    continue;
                }
                
                if (prefMatrix[x][i] < prefMatrix[x][y] && prefMatrix[i][x] < prefMatrix[i][map.get(i)]) {
                    res++;
                    break;
                }
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int n = 4;
        int[][] pref = {{1, 2, 3}, {3, 2, 0}, {3, 1, 0}, {1, 2, 0}};
        int[][] p = {{0, 1}, {2, 3}};
        System.out.println(new Solution().unhappyFriends(n, pref, p));
    }
}
