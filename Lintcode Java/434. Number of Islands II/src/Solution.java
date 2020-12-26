import java.util.ArrayList;
import java.util.List;

public class Solution {
    
    class UnionFind {
        private int[] parent, rank;
        private boolean[] visited;
        private int group;
        private int cols, rows;
        
        public UnionFind(int n, int rows, int cols) {
            parent = new int[n];
            rank = new int[n];
            visited = new boolean[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
            
            this.rows = rows;
            this.cols = cols;
        }
        
        public int find(int p) {
            if (p != parent[p]) {
                parent[p] = find(parent[p]);
            }
            
            return parent[p];
        }
        
        public void union(int p, int q) {
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
         
            group--;
        }
        
        public void add(Point p) {
            int x = p.x, y = p.y;
            if (visited[getId(x, y)]) {
                return;
            }
            
            visited[getId(x, y)] = true;
            group++;
            
            if (x > 0 && visited[getId(x - 1, y)]) {
                union(getId(x, y), getId(x - 1, y));
            }
            if (x < rows - 1 && visited[getId(x + 1, y)]) {
                union(getId(x, y), getId(x + 1, y));
            }
            if (y > 0 && visited[getId(x, y - 1)]) {
                union(getId(x, y), getId(x, y - 1));
            }
            if (y < cols - 1 && visited[getId(x, y + 1)]) {
                union(getId(x, y), getId(x, y + 1));
            }
        }
    
        private int getId(int x, int y) {
            return cols * x + y;
        }
        
        public int getGroup() {
            return group;
        }
    }
    
    /**
     * @param n:         An integer
     * @param m:         An integer
     * @param operators: an array of point
     * @return: an integer array
     */
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        
        if (operators == null || operators.length == 0) {
            return res;
        }
        
        UnionFind uf = new UnionFind(n * m, n, m);
    
        for (Point operator : operators) {
            uf.add(operator);
            res.add(uf.getGroup());
        }
        
        return res;
    }
}

class Point {
    int x, y;
    
    Point() {
        x = y = 0;
    }
    
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}