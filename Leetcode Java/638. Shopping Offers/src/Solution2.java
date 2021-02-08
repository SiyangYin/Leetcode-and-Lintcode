import java.util.*;

public class Solution2 {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return dfs(needs, new HashMap<>(), price, special);
    }
    
    private int dfs(List<Integer> needs, Map<List<Integer>, Integer> map, List<Integer> price, List<List<Integer>> special) {
        if (map.containsKey(needs)) {
            return map.get(needs);
        }
        
        int res = 0;
        for (int i = 0; i < price.size(); i++) {
            res += needs.get(i) * price.get(i);
        }
        
        for (int i = 0; i < special.size(); i++) {
            List<Integer> sp = special.get(i);
            if (fit(needs, sp)) {
                for (int j = 0; j < needs.size(); j++) {
                    needs.set(j, needs.get(j) - sp.get(j));
                }
                res = Math.min(res, sp.get(price.size()) + dfs(needs, map, price, special));
                for (int j = 0; j < needs.size(); j++) {
                    needs.set(j, needs.get(j) + sp.get(j));
                }
            }
        }
        
        map.put(needs, res);
        return res;
    }
    
    private boolean fit(List<Integer> needs, List<Integer> sp) {
        for (int i = 0; i < needs.size(); i++) {
            if (needs.get(i) < sp.get(i)) {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        ArrayList<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(2);
        l1.add(3);
        
        LinkedList<Integer> l2 = new LinkedList<>();
        l2.add(1);
        l2.add(2);
        l2.add(3);
        
        System.out.println(1 * 31 * 31 * 31 + 1 * 31 * 31 + 2 * 31 + 3);
        System.out.println(l1.hashCode());
        System.out.println(l1.equals(l2));
        
        Set<List<Integer>> set = new HashSet<>();
        set.add(l1);
        set.add(l2);
        System.out.println(set.size());
    }
}
