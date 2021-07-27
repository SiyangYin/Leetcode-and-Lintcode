public class Solution {
    
    class UnionFind {
        private int[] p;
        int group;
    
        public UnionFind(int size) {
            p = new int[size];
            for (int i = 0; i < size; i++) {
                p[i] = i;
            }
            group = size;
        }
        
        public int find(int x) {
            if (p[x] != x) {
                p[x] = find(p[x]);
            }
            
            return p[x];
        }
        
        public void union(int x, int y) {
            int px = find(x), py = find(y);
            if (px != py) {
                p[px] = py;
                group--;
            }
        }
    }
    
    public int numSimilarGroups(String[] strs) {
        UnionFind uf = new UnionFind(strs.length);
        for (int i = 0; i < strs.length; i++) {
            for (int j = i + 1; j < strs.length; j++) {
                if (areSimilar(strs[i], strs[j])) {
                    uf.union(i, j);
                }
            }
        }
        
        return uf.group;
    }
    
    private boolean areSimilar(String s, String t) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                cnt++;
            }
            
            if (cnt > 2) {
                return false;
            }
        }
        
        return true;
    }
}
