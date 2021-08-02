import java.util.HashMap;
import java.util.Map;

public class Solution {
    
    class UnionFind {
        private int[] p;
        int[] sz;
        
        public UnionFind(int size) {
            p = new int[size];
            sz = new int[size];
            for (int i = 0; i < size; i++) {
                p[i] = i;
                sz[i] = 1;
            }
        }
        
        public int find(int x) {
            if (p[x] != x) {
                p[x] = find(p[x]);
            }
            
            return p[x];
        }
        
        public void union(int x, int y) {
            int px = find(x), py = find(y);
            if (px != py) {
                p[px] = py;
                sz[py] += sz[px];
            }
        }
    }
    
    public int minSwapsCouples(int[] row) {
        UnionFind uf = new UnionFind(row.length / 2);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < row.length; i++) {
            if (map.containsKey(row[i] ^ 1)) {
                int id = map.get(row[i] ^ 1) / 2;
                uf.union(id, i / 2);
            }
            
            map.put(row[i], i);
        }
        
        int res = 0;
        for (int i = 0; i < row.length / 2; i++) {
            if (uf.find(i) == i) {
                res += uf.sz[i] - 1;
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[] r = {0, 2, 1, 3};
        System.out.println(new Solution().minSwapsCouples(r));
    }
}
