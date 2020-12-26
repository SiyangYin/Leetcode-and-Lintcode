import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    
    class UnionFind {
        Map<String, String> parent;
        Map<String, Integer> size;
        int maxsize;
        String maxroot;
    
        public UnionFind() {
            parent = new HashMap<>();
            size = new HashMap<>();
        }
        
        private String find(String s) {
            if (!s.equals(parent.get(s))) {
                parent.put(s, find(parent.get(s)));
            }
            
            return parent.get(s);
        }
        
        public void union(String x, String y) {
            parent.putIfAbsent(x, x);
            parent.putIfAbsent(y, y);
            size.putIfAbsent(x, 1);
            size.putIfAbsent(y, 1);
    
            String px = find(x), py = find(y);
            if (px.equals(py)) {
                return;
            }
            
            parent.put(px, py);
            size.put(py, size.get(px) + size.get(py));
            if (maxsize < size.get(py)) {
                maxsize = size.get(py);
                maxroot = py;
            }
        }
        
        public List<String> findMaxSet() {
            List<String> res = new ArrayList<>();
            for (String key : parent.keySet()) {
                if (find(key).equals(maxroot)) {
                    res.add(key);
                }
            }
            
            return res;
        }
    }
    
    /**
     * @param ListA: The relation between ListB's books
     * @param ListB: The relation between ListA's books
     * @return: The answer
     */
    public List<String> maximumAssociationSet(String[] ListA, String[] ListB) {
        // Write your code here
        UnionFind uf = new UnionFind();
        for (int i = 0; i < ListA.length; i++) {
            uf.union(ListA[i], ListB[i]);
        }
        
        return uf.findMaxSet();
    }
    
    public static void main(String[] args) {
        String[] A = {"a", "b", "d", "e", "f"}, B = {"b", "c", "e", "g", "g"};
        System.out.println(new Solution().maximumAssociationSet(A, B));
    }
}
