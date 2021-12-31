public class Solution {
    
    int[] p;
    
    int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        
        return p[x];
    }
    
    public boolean validPath(int n, int[][] edges, int start, int end) {
        p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }
        
        for (int[] edge : edges) {
            p[find(edge[0])] = find(edge[1]);
        }
        
        return find(start) == find(end);
    }
}
