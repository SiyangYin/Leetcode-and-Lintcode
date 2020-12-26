public class Solution {
    
    class UnionFind {
        int[] parent;
        int group;
        
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
        
        public void union(int x, int y) {
            int px = find(x), py = find(y);
            if (px == py) {
                return;
            }
            
            parent[px] = py;
            group--;
        }
        
        public int getGroup() {
            return group;
        }
    }
    
    /**
     * @param n: the person sum
     * @param a: the array a
     * @param b: the array b
     * @return: yes or no
     */
    public String socialNetwork(int n, int[] a, int[] b) {
        // Write your code here
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < a.length; i++) {
            uf.union(a[i] - 1, b[i] - 1);
        }
        return uf.getGroup() == 1 ? "yes" : "no";
    }
    
    public static void main(String[] args) {
        int[] a = {1, 1, 1}, b = {2, 3, 4};
        System.out.println(new Solution().socialNetwork(4, a, b));
    }
}
