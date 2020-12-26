import java.util.Arrays;

public class Solution {
    
    class UnionFind {
        private int[] parent;
        private int group;
    
        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
            group = n;
        }
        
        private int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        
        private boolean union(int x, int y) {
            int px = find(x), py = find(y);
            if (px == py) {
                return false;
            }
            
            parent[px] = py;
            group--;
            return true;
        }
    
        public int getGroup() {
            return group;
        }
    }
    
    public int minimumCost(int N, int[][] connections) {
        Arrays.sort(connections, (c1, c2) -> Integer.compare(c1[2], c2[2]));
        
        int res = 0;
        UnionFind uf = new UnionFind(N);
        for (int[] connection : connections) {
            if (uf.union(connection[0] - 1, connection[1] - 1)) {
                res += connection[2];
            }
        }
        
        return uf.getGroup() == 1 ? res : -1;
    }
    
    public static void main(String[] args) {
        int N = 3;
        int[][] co = {{1, 2, 5}, {1, 3, 6}, {2, 3, 1}};
        System.out.println(new Solution().minimumCost(3, co));
    }
}
