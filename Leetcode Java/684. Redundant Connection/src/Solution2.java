import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution2 {
    
    class UnionFind {
        int[] parent;
        int[] rank;
        
        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }
        
        public int find(int p) {
            if (p != parent[p]) {
                parent[p] = find(parent[p]);
            }
            
            return parent[p];
        }
        
        public boolean union(int p, int q) {
            int pid = find(p), qid = find(q);
            if (pid == qid) {
                return false;
            }
            
            if (rank[pid] < rank[qid]) {
                parent[pid] = qid;
            } else if (rank[pid] > rank[qid]) {
                parent[qid] = pid;
            } else {
                parent[pid] = qid;
                rank[qid]++;
            }
            
            return true;
        }
    }
    
    public int[] findRedundantConnection(int[][] edges) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < edges.length; i++) {
            set.add(edges[i][0]);
            set.add(edges[i][1]);
        }
        
        UnionFind uf = new UnionFind(set.size());
        for (int i = 0; i < edges.length; i++) {
            int p = edges[i][0], q = edges[i][1];
            if (!uf.union(p - 1, q - 1)) {
                return edges[i];
            }
        }
        
        return null;
    }
    
    public static void main(String[] args) {
        // int[][] edges = {{1, 2}, {1, 3}, {2, 3}};
        // int[][] edges = {{1, 3}, {3, 4}, {1, 5}, {3, 5}, {2, 3}};
        int[][] edges = {{7,8},{2,6},{2,8},{1,4},{9,10},{1,7},{3,9},{6,9},{3,5},{3,10}};
        System.out.println(Arrays.toString(new Solution2().findRedundantConnection(edges)));
    }
}
