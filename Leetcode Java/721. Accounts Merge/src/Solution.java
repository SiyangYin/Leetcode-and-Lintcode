import java.util.*;

public class Solution {
    
    class UnionFind {
        Map<String, String> parent;
    
        public UnionFind() {
            parent = new HashMap<>();
        }
        
        public void add(String x) {
            parent.putIfAbsent(x, x);
        }
        
        public String find(String x) {
            if (!x.equals(parent.get(x))) {
                parent.put(x, find(parent.get(x)));
            }
            
            return parent.get(x);
        }
        
        public void union(String x, String y) {
            String px = find(x), py = find(y);
            if (px.equals(py)) {
                return;
            }
            
            parent.put(px, py);
        }
        
        public Map<String, PriorityQueue<String>> group() {
            Map<String, PriorityQueue<String>> map = new HashMap<>();
            for (String s : parent.keySet()) {
                if (parent.get(s).equals(s)) {
                    map.putIfAbsent(s, new PriorityQueue<>());
                }
            }
            
            for (String s : parent.keySet()) {
                map.get(find(s)).add(s);
            }
            
            return map;
        }
    }
    
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new ArrayList<>();
    
        Map<String, String> map = new HashMap<>();
        UnionFind uf = new UnionFind();
        for (List<String> account : accounts) {
            for (int i = 1; i < account.size(); i++) {
                map.put(account.get(i), account.get(0));
                uf.add(account.get(i));
                if (i >= 2) {
                    uf.union(account.get(i), account.get(i - 1));
                }
            }
        }
    
        for (Map.Entry<String, PriorityQueue<String>> entry : uf.group().entrySet()) {
            List<String> list = new ArrayList<>();
            list.add(map.get(entry.getKey()));
            while (!entry.getValue().isEmpty()) {
                list.add(entry.getValue().poll());
            }
            
            res.add(list);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        // List<List<String>> e = Arrays.asList(
        //         Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"),
        //         Arrays.asList("John", "johnnybravo@mail.com"),
        //         Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"),
        //         Arrays.asList("Mary", "mary@mail.com"));
    
        List<List<String>> e = Arrays.asList(
                // Arrays.asList("Alex","Alex5@m.co","Alex4@m.co","Alex0@m.co"),
                // Arrays.asList("Ethan","Ethan3@m.co","Ethan3@m.co","Ethan0@m.co"),
                // Arrays.asList("Kevin","Kevin4@m.co","Kevin2@m.co","Kevin2@m.co"),
                Arrays.asList("Gabe","Gabe0@m.co","Gabe3@m.co","Gabe2@m.co"),
                Arrays.asList("Gabe","Gabe3@m.co","Gabe4@m.co","Gabe2@m.co"));
        System.out.println(new Solution().accountsMerge(e));
    }
}
