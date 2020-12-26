import java.util.Arrays;

public class Solution {
    
    class UnionFind {
        private int[] parent, rank;
        private int count;
        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
            count = n;
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
            
            count--;
        }
        
        public int getCount() {
            return count;
        }
    }
    
    public int earliestAcq(int[][] logs, int N) {
        Arrays.sort(logs, (l1, l2) -> Integer.compare(l1[0], l2[0]));
        UnionFind uf = new UnionFind(N);
        for (int i = 0; i < logs.length; i++) {
            int x = logs[i][1], y = logs[i][2];
            uf.union(x, y);
            if (uf.getCount() == 1) {
                return logs[i][0];
            }
        }
        
        return -1;
    }
}
