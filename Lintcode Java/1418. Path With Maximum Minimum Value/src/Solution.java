import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    
    class UnionFind {
        private int[] parent;
        
        public UnionFind(int size) {
            parent = new int[size];
            Arrays.fill(parent, -1);
        }
        
        public void insert(int x) {
            parent[x] = x;
        }
        
        public int find(int x) {
            if (parent[x] != x) {
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
        
        public boolean exists(int x) {
            return parent[x] != -1;
        }
    }
    
    class Pair {
        int x, y, val;
        
        public Pair(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
    
    /**
     * @param A: a List[List[int]]
     * @return: Return the maximum score of a path
     */
    public int maximumMinimumPath(int[][] A) {
        // Write your code here
        int m = A.length, n = A[0].length;
        UnionFind uf = new UnionFind(m * n);
        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                list.add(new Pair(i, j, A[i][j]));
            }
        }
        
        int start = 0, end = m * n - 1;
        int[] d = {1, 0, -1, 0, 1};
        list.sort((p1, p2) -> -Integer.compare(p1.val, p2.val));
        for (int i = 0; i < list.size(); i++) {
            Pair pair = list.get(i);
            int x = pair.x, y = pair.y;
            uf.insert(transfer(x, y, n));
            for (int j = 0; j < 4; j++) {
                int nextX = x + d[j], nextY = y + d[j + 1];
                if (0 <= nextX && nextX < m && 0 <= nextY && nextY < n && uf.exists(transfer(nextX, nextY, n))) {
                    uf.union(transfer(x, y, n), transfer(nextX, nextY, n));
                }
            }
            
            if (uf.exists(start) && uf.exists(end) && uf.find(start) == uf.find(end)) {
                return pair.val;
            }
        }
        
        return -1;
    }
    
    private int transfer(int x, int y, int n) {
        return x * n + y;
    }
    
    public static void main(String[] args) {
        int[][] A = {
                {5, 4, 5},
                {1, 2, 6},
                {7, 4, 6}};
        System.out.println(new Solution().maximumMinimumPath(A));
    }
}
