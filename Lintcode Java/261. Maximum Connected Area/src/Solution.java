import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    
    class UnionFind {
        int m, n;
        int[] parent, size;
        
        public UnionFind(int m, int n) {
            parent = new int[m * n];
            for (int i = 0; i < m * n; i++) {
                parent[i] = i;
            }
            
            size = new int[m * n];
            Arrays.fill(size, 1);
            
            this.m = m;
            this.n = n;
        }
        
        public void union(int x1, int y1, int x2, int y2) {
            union(transform(x1, y1), transform(x2, y2));
        }
        
        public void union(int a, int b) {
            int pa = find(a), pb = find(b);
            if (pa == pb) {
                return;
            }
            
            parent[pa] = pb;
            size[pb] += size[pa];
        }
        
        public int find(int x, int y) {
            return find(transform(x, y));
        }
        
        public int find(int a) {
            if (parent[a] != a) {
                parent[a] = find(parent[a]);
            }
            
            return parent[a];
        }
        
        public int getSize(int x, int y) {
            return size[transform(x, y)];
        }
        
        public int getSize(int a) {
            return size[a];
        }
        
        private int transform(int x, int y) {
            return x * n + y;
        }
    }
    
    /**
     * @param matrix: the matrix for calculation.
     * @return: return the max area after operation at most once.
     */
    public int maxArea(int[][] matrix) {
        // write your code here.
        int m = matrix.length, n = matrix[0].length;
        UnionFind uf = new UnionFind(m, n);
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    int[] d = {1, 0, -1, 0, 1};
                    for (int k = 0; k < 4; k++) {
                        int nextX = i + d[k], nextY = j + d[k + 1];
                        if (inBound(nextX, nextY, matrix) && matrix[nextX][nextY] == 1) {
                            uf.union(i, j, nextX, nextY);
                        }
                    }
                }
            }
        }
    
        int res = 0;
        boolean found = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    found = true;
                    int[] d = {1, 0, -1, 0, 1};
                    Set<Integer> set = new HashSet<>();
                    for (int k = 0; k < 4; k++) {
                        int nextX = i + d[k], nextY = j + d[k + 1];
                        if (inBound(nextX, nextY, matrix) && matrix[nextX][nextY] == 1) {
                            set.add(uf.find(nextX, nextY));
                        }
                    }
    
                    int curArea = 1;
                    for (int num : set) {
                        curArea += uf.getSize(num);
                    }
                    
                    res = Math.max(res, curArea);
                }
            }
        }
        
        return found ? res : m * n;
    }
    
    private boolean inBound(int x, int y, int[][] matrix) {
        return 0 <= x && x < matrix.length && 0 <= y && y < matrix[0].length;
    }
    
    public static void main(String[] args) {
        int[][] mat = {
                {0, 1, 1},
                // {1, 0, 0},
                {1, 0, 0}};
        System.out.println(new Solution().maxArea(mat));
    }
}
