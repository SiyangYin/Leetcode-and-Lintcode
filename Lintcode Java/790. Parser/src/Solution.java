import java.util.*;

public class Solution {
    /**
     * @param generator: Generating set of rules.
     * @param startSymbol: Start symbol.
     * @param symbolString: Symbol string.
     * @return: Return true if the symbol string can be generated, otherwise return false.
     */
    public boolean canBeGenerated(String[] generator, char startSymbol, String symbolString) {
        // Write  your code here.
        if (symbolString.equals(String.valueOf(startSymbol))) {
            return true;
        }
        
        Map<Character, Set<String>> map = new HashMap<>();
        for (String s : generator) {
            String[] split = s.split(" -> ");
            map.putIfAbsent(split[0].charAt(0), new HashSet<>());
            map.get(split[0].charAt(0)).add(split[1]);
        }
        
        return dfs(String.valueOf(startSymbol), symbolString, map);
    }
    
    private boolean dfs(String start, String symbol, Map<Character, Set<String>> map) {
        if (start.equals(symbol)) {
            return true;
        }
        
        if (start.length() > symbol.length()) {
            return false;
        }
    
        for (String neighbor : getNeighbors(start, map)) {
            if (dfs(neighbor, symbol, map)) {
                return true;
            }
        }
        
        return false;
    }
    
    private List<String> getNeighbors(String s, Map<Character, Set<String>> map) {
        List<String> neighbors = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            Set<String> replacement = map.get(s.charAt(i));
            if (replacement != null) {
                for (String replace : replacement) {
                    neighbors.add(s.substring(0, i) + replace + s.substring(i + 1));
                }
            }
        }
        
        return neighbors;
    }
    
    public static void main(String[] args) {
        String[] generator = {"S -> abc", "S -> aA", "A -> b", "A -> c"};
        System.out.println(new Solution().canBeGenerated(generator, 'S', "ac"));
    
    }
}
