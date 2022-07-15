import java.util.*;

public class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, Set<String>> g = new HashMap<>();
        Map<String, Integer> ind = new HashMap<>();
        for (int i = 0; i < recipes.length; i++) {
            String re = recipes[i];
            for (String s : ingredients.get(i)) {
                g.putIfAbsent(s, new HashSet<>());
                g.get(s).add(re);
                ind.put(re, ind.getOrDefault(re, 0) + 1);
            }
        }
        
        Queue<String> q = new LinkedList<>();
        for (String s : supplies) {
            q.offer(s);
        }
    
        Set<String> rec = new HashSet<>(Arrays.asList(recipes));
        
        List<String> res = new ArrayList<>();
        while (!q.isEmpty()) {
            String s = q.poll();
            if (rec.contains(s)) {
                res.add(s);
            }
            if (g.containsKey(s)) {
                for (String ne : g.get(s)) {
                    ind.put(ne, ind.get(ne) - 1);
                    if (ind.get(ne) == 0) {
                        q.offer(ne);
                    }
                }
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        String[] re = {"bread"};
        List<List<String>> ing = new ArrayList<>();
        ing.add(Arrays.asList("yeast", "flour"));
        String[] su = {"yeast", "flour", "corn"};
        System.out.println(new Solution().findAllRecipes(re, ing, su));
    }
}
