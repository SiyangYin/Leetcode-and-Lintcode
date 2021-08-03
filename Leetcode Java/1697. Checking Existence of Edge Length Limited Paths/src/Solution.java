import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    
    class UnionFind {
        int[] p;
        
        public UnionFind(int size) {
            p = new int[size];
            for (int i = 0; i < size; i++) {
                p[i] = i;
            }
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
            }
        }
    }
    
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        List<Integer> id = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            id.add(i);
        }
        id.sort((x, y) -> Integer.compare(queries[x][2], queries[y][2]));
        
        UnionFind uf = new UnionFind(n);
        Arrays.sort(edgeList, (e1, e2) -> Integer.compare(e1[2], e2[2]));
        
        boolean[] res = new boolean[queries.length];
        for (int i = 0, j = 0; i < id.size(); i++) {
            int idx = id.get(i);
            int x = queries[idx][0], y = queries[idx][1], len = queries[idx][2];
            while (j < edgeList.length && edgeList[j][2] < len) {
                uf.union(edgeList[j][0], edgeList[j][1]);
                j++;
            }
            
            res[idx] = uf.find(x) == uf.find(y);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int n = 5;
        int[][] e = {{0, 1, 10}, {1, 2, 5}, {2, 3, 9}, {3, 4, 13}};
        int[][] q = {{0, 4, 14}, {1, 4, 13}};
        System.out.println(Arrays.toString(new Solution().distanceLimitedPathsExist(n, e, q)));
    }
}
