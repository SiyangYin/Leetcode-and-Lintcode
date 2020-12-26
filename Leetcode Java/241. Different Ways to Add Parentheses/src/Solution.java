import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        return dfs(input, new HashMap<>());
    }
    
    private List<Integer> dfs(String input, Map<String, List<Integer>> map) {
        if (map.containsKey(input)) {
            return map.get(input);
        }
        
        List<Integer> res = new ArrayList<>();
        for (int k = 0; k < input.length(); k++) {
            char ch = input.charAt(k);
            if (ch == '-' || ch == '*' || ch == '+') {
                String s1 = input.substring(0, k), s2 = input.substring(k + 1);
                List<Integer> part1 = dfs(s1, map), part2 = dfs(s2, map);
            
                for (int p1 : part1) {
                    for (int p2 : part2) {
                        switch (ch) {
                            case '+': res.add(p1 + p2); break;
                            case '-': res.add(p1 - p2); break;
                            case '*': res.add(p1 * p2); break;
                        }
                    }
                }
            }
        }
    
        if (res.isEmpty()) {
            res.add(Integer.parseInt(input));
        }
        
        map.put(input, res);
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().diffWaysToCompute("2*3-4*5"));
        System.out.println(new Solution().diffWaysToCompute("1*1-1*1"));
    }
}
