import java.util.HashMap;
import java.util.Map;

public class Solution {
    
    private int[] parent;
    
    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        
        return parent[x];
    }
    
    private void union(int x, int y) {
        int px = find(x), py = find(y);
        if (px == py) {
            return;
        }
        
        parent[px] = py;
    }
    
    public int largestComponentSize(int[] A) {
        int max = 0;
        for (int x : A) {
            max = Math.max(max, x);
        }
        
        parent = new int[max + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        
        for (int x : A) {
            int y = x;
            for (int i = 2; i <= y / i; i++) {
                if (y % i == 0) {
                    while (y % i == 0) {
                        y /= i;
                    }
                    
                    union(x, i);
                }
            }
            
            if (y > 1) {
                union(x, y);
            }
        }
        
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : A) {
            int px = find(x);
            map.put(px, map.getOrDefault(px, 0) + 1);
        }
    
        for (int cnt : map.values()) {
            res = Math.max(res, cnt);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().largestComponentSize(new int[]{4, 6, 9}));
    }
}
