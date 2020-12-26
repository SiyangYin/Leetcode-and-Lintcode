import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    
    class UnionFind {
        int[] parent, rank;
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
        
        public void union(int p, int q) {
            int pRoot = find(p), qRoot = find(q);
            if (rank[pRoot] < rank[qRoot]) {
                parent[pRoot] = qRoot;
            } else if (rank[pRoot] > rank[qRoot]) {
                parent[qRoot] = pRoot;
            } else {
                parent[pRoot] = qRoot;
                rank[qRoot]++;
            }
        }
    }
    
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
        if (words1.length != words2.length) {
            return false;
        }
    
        UnionFind uf = new UnionFind(pairs.size());
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < pairs.size(); i++) {
            String s1 = pairs.get(i).get(0), s2 = pairs.get(i).get(1);
            if (map.containsKey(s1) && map.containsKey(s2)) {
                uf.union(map.get(s1), map.get(s2));
            } else if (!map.containsKey(s1) && !map.containsKey(s2)) {
                map.put(s1, i);
                map.put(s2, i);
            } else if (map.containsKey(s1)) {
                map.put(s2, map.get(s1));
            } else {
                map.put(s1, map.get(s2));
            }
        }
    
        for (int i = 0; i < words1.length; i++) {
            String s1 = words1[i], s2 = words2[i];
            if (s1.equals(s2)) {
                continue;
            }
            
            if (!map.containsKey(s1) || !map.containsKey(s2)) {
                return false;
            }
            
            if (uf.find(map.get(s1)) != uf.find(map.get(s2))) {
                return false;
            }
        }
        
        return true;
    }
}
