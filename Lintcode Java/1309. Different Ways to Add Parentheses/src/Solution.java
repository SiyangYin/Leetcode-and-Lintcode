import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    /**
     * @param input: a string
     * @return: return List[int]
     */
    public List<Integer> diffWaysToCompute(String input) {
        // write your code here
        return dfs(input, new HashMap<>());
    }
    
    private List<Integer> dfs(String input, Map<String, List<Integer>> map) {
        if (map.containsKey(input)) {
            return map.get(input);
        }
    
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                List<Integer> left = dfs(input.substring(0, i), map), right = dfs(input.substring(i + 1), map);
                for (int l : left) {
                    for (int r : right) {
                        switch (input.charAt(i)) {
                            case '+': res.add(l + r); break;
                            case '-': res.add(l - r); break;
                            case '*': res.add(l * r); break;
                            case '/': res.add(l / r); break;
                        }
                    }
                }
            }
        }
        
        if (res.isEmpty()) {
            res.add(Integer.parseInt(input));
        }
        
        map.putIfAbsent(input, res);
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().diffWaysToCompute("2-1-1"));
    }
}
