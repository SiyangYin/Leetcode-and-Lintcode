public class Solution {
    
    class UnionFind {
        private int[] parent, count;
        
        public UnionFind(int n) {
            parent = new int[n];
            count = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                count[i] = 1;
            }
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
            count[py] += count[px];
        }
        
        public int getCount(int x) {
            return count[find(x)];
        }
    }
    
    /**
     * @param n:      the number of members in team.
     * @param groups: the groups.
     * @return: return how many members will get notifications.
     */
    public int teamNotification(int n, int[][] groups) {
        // write your code here.
        UnionFind uf = new UnionFind(n);
        for (int[] group : groups) {
            if (group.length == 0) {
                continue;
            }
            
            int x = group[0];
            for (int i = 1; i < group.length; i++) {
                uf.union(x, group[i]);
            }
        }
        
        return uf.getCount(0);
    }
    
    public static void main(String[] args) {
        int[][] g = {{0, 1, 2}, {1, 3}, {4, 5}};
        System.out.println(new Solution().teamNotification(6, g));
    }
}
