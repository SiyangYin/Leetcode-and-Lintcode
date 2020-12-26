import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    
    class UnionFind {
        
        private int[] parent, rank;
        private int count;
        
        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            Arrays.fill(parent, -1);
            Arrays.fill(rank, 1);
        }
        
        public int find(int p) {
            if (p != parent[p]) {
                parent[p] = find(parent[p]);
            }
            
            return parent[p];
        }
        
        public void union(int p, int q) {
            if (parent[p] == -1 || parent[q] == -1) {
                return;
            }
            
            int pRoot = find(p), qRoot = find(q);
            if (pRoot == qRoot) {
                return;
            }
            
            if (rank[pRoot] < rank[qRoot]) {
                parent[pRoot] = qRoot;
            } else if (rank[pRoot] > rank[qRoot]) {
                parent[qRoot] = pRoot;
            } else {
                parent[pRoot] = qRoot;
                rank[qRoot]++;
            }
            count--;
        }
        
        public int getCount() {
            return count;
        }
        
        private void add(int x, int y, int m, int n) {
            int pos = mapToInt(x, y, n);
            if (parent[pos] != -1) {
                return;
            }
            
            parent[pos] = pos;
            count++;
            
            if (x + 1 < m) {
                union(mapToInt(x, y, n), mapToInt(x + 1, y, n));
            }
            if (x - 1 >= 0) {
                union(mapToInt(x, y, n), mapToInt(x - 1, y, n));
            }
            if (y + 1 < n) {
                union(mapToInt(x, y, n), mapToInt(x, y + 1, n));
            }
            if (y - 1 >= 0) {
                union(mapToInt(x, y, n), mapToInt(x, y - 1, n));
            }
        }
    
        private int mapToInt(int x, int y, int n) {
            return x * n + y;
        }
    }
    
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        UnionFind uf = new UnionFind(m * n);
        for (int i = 0; i < positions.length; i++) {
            int x = positions[i][0], y = positions[i][1];
            uf.add(x, y, m, n);
            res.add(uf.getCount());
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int m = 1, n = 2;
        // int[][] pos = {{0, 0}, {0, 1}, {1, 2}, {2, 1}};
        int[][] pos = {{0, 1}, {0, 0}};
        System.out.println(new Solution().numIslands2(m, n, pos));
    }
    
}
