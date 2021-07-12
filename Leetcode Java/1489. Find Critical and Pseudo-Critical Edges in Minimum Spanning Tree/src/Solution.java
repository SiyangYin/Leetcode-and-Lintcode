import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    
    class UnionFind {
        int[] p;
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
        
        public int getGroup() {
            return group;
        }
    }
    
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0], y = edges[i][1], len = edges[i][2];
            edges[i] = new int[]{x, y, len, i};
        }
        
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        res.add(new ArrayList<>());
        
        Arrays.sort(edges, (e1, e2) -> Integer.compare(e1[2], e2[2]));
        int minCost = MST(edges, -1, -1, n);
        for (int i = 0; i < edges.length; i++) {
            int cost = MST(edges, i, -1, n), idx = edges[i][3];
            if (cost > minCost) {
                res.get(0).add(idx);
            } else if (MST(edges, -1, i, n) == minCost) {
                res.get(1).add(idx);
            }
        }
        
        return res;
    }
    
    private int MST(int[][] edges, int deleted, int required, int n) {
        UnionFind uf = new UnionFind(n);
        int res = 0;
        if (required != -1) {
            int[] edge = edges[required];
            uf.union(edge[0], edge[1]);
            res += edge[2];
        }
        
        for (int i = 0; i < edges.length; i++) {
            if (i == required || i == deleted) {
                continue;
            }
            
            int[] edge = edges[i];
            int x = edge[0], y = edge[1];
            if (uf.find(x) != uf.find(y)) {
                uf.union(x, y);
                res += edge[2];
                
                if (uf.getGroup() == 1) {
                    return res;
                }
            }
        }
        
        return Integer.MAX_VALUE;
    }
    
    public static void main(String[] args) {
        int n = 6;
        int[][] e = {{0, 1, 1}, {1, 2, 1}, {0, 2, 1}, {2, 3, 4}, {3, 4, 2}, {3, 5, 2}, {4, 5, 2}};
        System.out.println(new Solution().findCriticalAndPseudoCriticalEdges(n, e));
    }
}
