import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    
    class UnionFind {
        
        private int[] parent;
        private int size;
        
        public UnionFind(int size) {
            parent = new int[size];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
            
            this.size = size;
        }
        
        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            
            return parent[x];
        }
        
        public void union(int x, int y) {
            int px = find(x), py = find(y);
            if (px == py) {
                return;
            }
            
            parent[px] = py;
        }
    }
    
    public int maximumMinimumPath(int[][] A) {
        int m = A.length, n = A[0].length;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                list.add(new int[]{i, j});
            }
        }
        
        list.sort((p1, p2) -> -Integer.compare(A[p1[0]][p1[1]], A[p2[0]][p2[1]]));
        
        UnionFind uf = new UnionFind(m * n);
        
        int[] dir = {1, 0, -1, 0, 1};
        boolean[][] visited = new boolean[m][n];
        int start = 0, end = m * n - 1;
        for (int i = 0; i < list.size(); i++) {
            int[] pair = list.get(i);
            int x = pair[0], y = pair[1];
            visited[x][y] = true;
            
            for (int j = 0; j < 4; j++) {
                int nextX = x + dir[j], nextY = y + dir[j + 1];
                if (0 <= nextX && nextX < m && 0 <= nextY && nextY < n && visited[nextX][nextY]) {
                    uf.union(transform(x, y, n), transform(nextX, nextY, n));
                }
                
                if (uf.find(start) == uf.find(end)) {
                    return A[x][y];
                }
            }
        }
        
        return 0;
    }
    
    private int transform(int x, int y, int n) {
        return x * n + y;
    }
    
    public static void main(String[] args) {
        int[][] A = {{5, 4, 5}, {1, 2, 6}, {7, 4, 6}};
        System.out.println(new Solution2().maximumMinimumPath(A));
    }
}
