import java.util.*;

public class Solution {
    
    class UnionFind {
        private Map<String, String> parent;
        
        public UnionFind() {
            parent = new HashMap<>();
        }
        
        public void add(String s) {
            parent.putIfAbsent(s, s);
        }
        
        public String find(String s) {
            if (!parent.get(s).equals(s)) {
                parent.put(s, find(parent.get(s)));
            }
            
            return parent.get(s);
        }
        
        public void union(String s1, String s2) {
            parent.putIfAbsent(s1, s1);
            parent.putIfAbsent(s2, s2);
            
            String p1 = find(s1), p2 = find(s2);
            if (p1.equals(p2)) {
                return;
            }
            
            parent.put(p1, p2);
        }
        
        public Map<String, Set<String>> getParents() {
            Map<String, Set<String>> res = new HashMap<>();
            for (Map.Entry<String, String> entry : parent.entrySet()) {
                if (entry.getKey().equals(entry.getValue())) {
                    res.putIfAbsent(entry.getKey(), new TreeSet<>());
                }
            }
    
            for (String s : parent.keySet()) {
                String par = find(s);
                res.get(par).add(s);
            }
            
            return res;
        }
    }
    
    /**
     * @param accounts: List[List[str]]
     * @return: return a List[List[str]]
     */
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // write your code here
        UnionFind uf = new UnionFind();
        Map<String, String> emailToUser = new HashMap<>();
        for (List<String> account : accounts) {
            for (int i = 1; i < account.size(); i++) {
                emailToUser.put(account.get(i), account.get(0));
                uf.add(account.get(i));
                if (i + 1 < account.size()) {
                    uf.union(account.get(i), account.get(i + 1));
                }
            }
        }
    
        List<List<String>> res = new ArrayList<>();
        Map<String, Set<String>> parents = uf.getParents();
    
    
        for (Map.Entry<String, Set<String>> entry : parents.entrySet()) {
            String key = entry.getKey();
            List<String> acct = new ArrayList<>();
            acct.add(emailToUser.get(key));
            Set<String> value = entry.getValue();
            acct.addAll(value);
            res.add(acct);
        }
        
        return res;
    }
    
    // public static void main(String[] args) {
    //     List<List<String>> acc = new ArrayList<>();
    //     acc.add(new ArrayList<>(){{
    //         add("John");
    //         add("johnsmith@mail.com");
    //         add("john00@mail.com");
    //     }});
    //
    //     acc.add(new ArrayList<>(){{
    //         add("John");
    //         add("johnnybravo@mail.com");
    //     }});
    //
    //     acc.add(new ArrayList<>(){{
    //         add("John");
    //         add("johnsmith@mail.com");
    //         add("john_newyork@mail.com");
    //     }});
    //
    //     acc.add(new ArrayList<>(){{
    //         add("Mary");
    //         add("mary@mail.com");
    //     }});
    //
    //
    //     List<List<String>> res = new Solution().accountsMerge(acc);
    //     for (List<String> re : res) {
    //         System.out.println(re);
    //     }
    // }
}
