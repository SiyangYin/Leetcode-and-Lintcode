import java.util.HashMap;
import java.util.Map;

public class Solution {
    
    class UnionFind {
        private Map<String, String> parent;
        private int size;
    
        public UnionFind() {
            parent = new HashMap<>();
        }
    
        public void insert(String s) {
            if (!parent.containsKey(s)) {
                parent.put(s, s);
                size++;
            }
        }
        
        public String find(String s) {
            if (!s.equals(parent.get(s))) {
                parent.put(s, find(parent.get(s)));
            }
            
            return parent.get(s);
        }
        
        public void union(String x, String y) {
            String px = find(x), py = find(y);
            if (px.equals(py)) {
                return;
            }
            
            parent.put(x, py);
            size--;
        }
    
        public int getSize() {
            return size;
        }
    }
    
    /**
     * @param A: a string array
     * @return: the number of groups
     */
    public int numSimilarGroups(String[] A) {
        // Write your code here
        UnionFind uf = new UnionFind();
        for (String s : A) {
            uf.insert(s);
        }
    
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (check(A[i], A[j])) {
                    uf.union(A[i], A[j]);
                }
            }
        }
        
        return uf.getSize();
    }
    
    private boolean check(String s1, String s2) {
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
            }
            
            if (diff > 2) {
                return false;
            }
        }
        
        return diff == 2;
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().numSimilarGroups(new String[]{"tars", "rats", "arts", "star"}));
        System.out.println(new Solution().numSimilarGroups(new String[]{"aa", "aa", "aa", "aa"}));
    }
}
