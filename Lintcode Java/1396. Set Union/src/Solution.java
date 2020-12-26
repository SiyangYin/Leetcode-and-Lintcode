import java.util.Arrays;

public class Solution {
    
    class UnionFind {
        int[] parent, rank;
        int group = 0;
        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
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
            set(p);
            set(q);
            int pRoot = find(p), qRoot = find(q);
            if (pRoot == qRoot) {
                return;
            }
            
            if (rank[pRoot] < rank[qRoot]) {
                parent[pRoot] = qRoot;
            } else if (rank[qRoot] < rank[pRoot]) {
                parent[qRoot] = pRoot;
            } else {
                parent[pRoot] = qRoot;
                rank[qRoot]++;
            }
            group--;
        }
        
        private void set(int p) {
            if (parent[p] == -1) {
                parent[p] = p;
                group++;
            }
        }
    }
    
    /**
     * @param sets: Initial set list
     * @return: The final number of sets
     */
    public int setUnion(int[][] sets) {
        // Write your code here
        if (sets == null || sets.length == 0) {
            return 0;
        }
        
        int max = 0;
        for (int i = 0; i < sets.length; i++) {
            for (int j = 0; j < sets[i].length; j++) {
                max = Math.max(max, sets[i][j]);
            }
        }
    
        UnionFind uf = new UnionFind(max + 1);
        for (int i = 0; i < sets.length; i++) {
            for (int j = 0; j < sets[i].length; j++) {
                uf.set(sets[i][j]);
                if (j > 0) {
                    uf.union(sets[i][j], sets[i][j - 1]);
                }
            }
        }
        
        return uf.group;
    }
    
    public static void main(String[] args) {
        int[][] sets = {{1}, {1, 2, 3}, {4}, {8, 7, 4, 5}};
        System.out.println(new Solution().setUnion(sets));
    }
}
