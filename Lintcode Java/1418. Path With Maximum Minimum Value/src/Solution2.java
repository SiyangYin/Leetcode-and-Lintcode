import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    
    class Edge {
        int x, y, len;
        
        public Edge(int x, int y, int len) {
            this.x = x;
            this.y = y;
            this.len = len;
        }
    }
    
    class UnionFind {
        int[] parent;
        
        public UnionFind(int size) {
            parent = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }
        
        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            
            return parent[x];
        }
        
        public void union(int x, int y) {
            int px = find(x), py = find(y);
            if (px != py) {
                parent[px] = py;
            }
        }
    }
    
    /**
     * @param A: a List[List[int]]
     * @return: Return the maximum score of a path
     */
    public int maximumMinimumPath(int[][] A) {
        // Write your code here
        if (A.length == 1 && A[0].length == 1) {
            return A[0][0];
        }
        
        List<Edge> list = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (j + 1 < A[0].length) {
                    list.add(new Edge(transform(i, j, A), transform(i, j + 1, A), Math.min(A[i][j], A[i][j + 1])));
                }
                if (i + 1 < A.length) {
                    list.add(new Edge(transform(i, j, A), transform(i + 1, j, A), Math.min(A[i][j], A[i + 1][j])));
                }
            }
        }
        
        list.sort((e1, e2) -> -Integer.compare(e1.len, e2.len));
        UnionFind uf = new UnionFind(A.length * A[0].length);
        for (Edge e : list) {
            uf.union(e.x, e.y);
            if (uf.find(0) == uf.find(transform(A.length - 1, A[0].length - 1, A))) {
                return e.len;
            }
        }
        
        return -1;
    }
    
    private int transform(int x, int y, int[][] A) {
        return x * A[0].length + y;
    }
    
    public static void main(String[] args) {
        // int[][] A = {
        //         {2, 2, 1, 2, 2, 2},
        //         {1, 2, 2, 2, 1, 2}};
        int[][] A = {{1}};
        System.out.println(new Solution2().maximumMinimumPath(A));
    }
}
